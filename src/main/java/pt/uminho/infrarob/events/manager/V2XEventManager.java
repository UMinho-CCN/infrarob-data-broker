package pt.uminho.infrarob.events.manager;

import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import pt.uminho.infrarob.common.objects.Brokers;
import pt.uminho.infrarob.common.objects.PolygonDataSource;
import pt.uminho.infrarob.common.objects.VehiclePosition;
import pt.uminho.infrarob.common.singleton.MqttConnectionShare;
import pt.uminho.infrarob.common.singleton.PolygonCoordinatesSingleton;
import pt.uminho.infrarob.common.singleton.VehicleDataShare;
import pt.uminho.infrarob.events.events.*;
import pt.uminho.infrarob.websocketconnector.objects.PolygonCoordinates;

import java.nio.DoubleBuffer;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class V2XEventManager {
    private long ID = 0;

    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    @Value("${polygon.source:web}")
    private PolygonDataSource polygonSource;

    @Value("${polygon.src.station}")
    private String [] polygonSRCs;

    @Value("${storage.cash:true}")
    private boolean storeInCash;

    @Value("${forward.enable:false}")
    private boolean sendToBroker;

    @Value("${forward.broker:MQTT}")
    private Brokers broker;

    @Value(("${infraction.speed}"))
    private int speedThreshold;

    @Value(("${infraction.jerks}"))
    private int jerkThreshold;

    @Async
    @EventListener
    public void handleReceivedV2XMessage(V2XMessageReceivedEvent message){
        VehiclePosition vehiclePosition = message.getVehiclePosition();
        handleStorage(vehiclePosition);
        handleForward(vehiclePosition);

        boolean isPolygon = handlePolygon(vehiclePosition);


        if(!isPolygon) {
            handleSafeZone(vehiclePosition);
        }

        checkSpeed(vehiclePosition);
        checkJerk(vehiclePosition);
    }

    private void handleStorage(VehiclePosition vehiclePosition){
        if(storeInCash){
            VehicleDataShare.getInstance().addVehiclePosition(vehiclePosition);
        }
    }

    private void handleForward(VehiclePosition vehiclePosition) {
        if (!sendToBroker) {
            return;
        }

        if (broker == Brokers.MQTT) {
            try {
                MqttMessage mqttMessage = new MqttMessage(vehiclePosition.toStringWithID(ID).getBytes(StandardCharsets.UTF_8));
                MqttConnectionShare.getInstance().publishToClient(mqttMessage);
                ID++;
            } catch (MqttException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private boolean handlePolygon(VehiclePosition vehiclePosition){
        if(polygonSource == PolygonDataSource.V2X){
            List<String> srcs = Arrays.asList(polygonSRCs);
            int stationIndex = srcs.indexOf(vehiclePosition.getVehicleID());
            if(stationIndex >= 0) {
                System.out.println();
                PolygonCoordinateEvent polygonCoordinateEvent = new PolygonCoordinateEvent(
                        this,
                        new PolygonCoordinates(
                                Double.parseDouble(vehiclePosition.getLat()),
                                Double.parseDouble(vehiclePosition.getLon()),
                                stationIndex),
                        polygonSource);
                applicationEventPublisher.publishEvent(polygonCoordinateEvent);
                return true;
            }
        }
        return false;
    }

    private void handleSafeZone(VehiclePosition vehiclePosition){
        boolean isInside = PolygonCoordinatesSingleton.getIntance().isInside(
                Double.parseDouble(vehiclePosition.getLat()),
                Double.parseDouble(vehiclePosition.getLon()));

        VehiclePosition pastPosition = VehicleDataShare.getInstance().getVehiclePosition(vehiclePosition.getVehicleID());

        boolean pastInside = pastPosition == null ? isInside : pastPosition.isInside();

        if (pastInside && !isInside) {
            SafeZoneInfractionEvent event = new SafeZoneInfractionEvent(this, pastPosition);
            applicationEventPublisher.publishEvent(event);
        }

        VehicleDataShare.getInstance().getVehiclePosition(vehiclePosition.getVehicleID()).setInside(isInside);
    }

    private void checkSpeed(VehiclePosition vehiclePosition){
        if(vehiclePosition.getSpeed() > speedThreshold){
            SpeedInfractionEvent speedInfractionEvent = new SpeedInfractionEvent(this, vehiclePosition);
            applicationEventPublisher.publishEvent(speedInfractionEvent);
        }
    }

    private void checkJerk(VehiclePosition vehiclePosition){
        //double jerk = diffAcc/((double)(getOperatingSystem().getSimulationTime()-lastEvent)/(double)TIME.SECOND);
        VehiclePosition pastPosition = VehicleDataShare.getInstance().getVehiclePosition(vehiclePosition.getVehicleID());
        double acc = Math.abs(vehiclePosition.getAcc() - pastPosition.getAcc());
        long time = vehiclePosition.getLastUpdate() - pastPosition.getLastUpdate();

        double jerk = acc/time;

        if(jerk > jerkThreshold){
            JerkInfractionEvent event = new JerkInfractionEvent(this, vehiclePosition);
            applicationEventPublisher.publishEvent(event);
        }
    }

}
