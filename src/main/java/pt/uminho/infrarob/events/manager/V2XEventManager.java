package pt.uminho.infrarob.events.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import pt.uminho.infrarob.common.objects.Brokers;
import pt.uminho.infrarob.common.objects.V2XWarning;
import pt.uminho.infrarob.common.objects.WarningType;
import pt.uminho.infrarob.common.objects.internal.InternalEventData;
import pt.uminho.infrarob.common.objects.internal.InternalObjectData;
import pt.uminho.infrarob.common.objects.PolygonDataSource;
import pt.uminho.infrarob.common.objects.ws.PolygonCoordinatesWS;
import pt.uminho.infrarob.common.singleton.PolygonCoordinatesSingleton;
import pt.uminho.infrarob.common.singleton.VehicleDataShare;
import pt.uminho.infrarob.events.events.*;

import java.util.Arrays;
import java.util.List;

@Component
public class V2XEventManager {

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
        InternalObjectData internalObjectData = message.getVehiclePosition();
        handleStorage(internalObjectData);
        handleForward(internalObjectData);

        boolean isPolygon = handlePolygon(internalObjectData);


        if(!isPolygon) {
            handleSafeZone(internalObjectData);
        }

        checkSpeed(internalObjectData);
        checkJerk(internalObjectData);
    }

    private void handleStorage(InternalObjectData internalObjectData){
        if(storeInCash){
            VehicleDataShare.getInstance().addVehiclePosition(internalObjectData);
        }
    }

    private void handleForward(InternalObjectData internalObjectData) {
        if (!sendToBroker) {
            return;
        }

        if (broker == Brokers.MQTT) {
            MQTTEvent mqttEvent = new MQTTEvent(this, internalObjectData, null);
            applicationEventPublisher.publishEvent(mqttEvent);
        }
    }

    private boolean handlePolygon(InternalObjectData internalObjectData){
        if(polygonSource == PolygonDataSource.V2X){
            List<String> srcs = Arrays.asList(polygonSRCs);
            int stationIndex = srcs.indexOf(internalObjectData.getVehicleID());
            if(stationIndex >= 0) {
                PolygonCoordinateEvent polygonCoordinateEvent = new PolygonCoordinateEvent(
                        this,
                        new PolygonCoordinatesWS(
                                internalObjectData.getConvertedLat(),
                                internalObjectData.getConvertedLon(),
                                stationIndex),
                        polygonSource);
                applicationEventPublisher.publishEvent(polygonCoordinateEvent);
                InternalEventData eventData = new InternalEventData();
                eventData.setEventType(WarningType.SAFEZONE_INFRACION.toString());
                eventData.setEventID(1);
                eventData.setAltitude(0);
                eventData.setLon(internalObjectData.getLon());
                eventData.setLat(internalObjectData.getLat());
                eventData.setRadius(0);

                MQTTEvent mqttEvent = new MQTTEvent(this, internalObjectData,eventData);
                applicationEventPublisher.publishEvent(mqttEvent);
                return true;
            }
        }
        return false;
    }

    private void handleSafeZone(InternalObjectData internalObjectData){
        boolean isInside = PolygonCoordinatesSingleton.getIntance().isInside(
                internalObjectData.getConvertedLat(),
                internalObjectData.getConvertedLon());

        InternalObjectData pastPosition = VehicleDataShare.getInstance().getVehiclePosition(internalObjectData.getVehicleID());

        boolean pastInside = pastPosition == null ? isInside : pastPosition.isInside();

        if (pastInside && !isInside) {
            SafeZoneInfractionEvent event = new SafeZoneInfractionEvent(this, pastPosition);
            applicationEventPublisher.publishEvent(event);
        }

        VehicleDataShare.getInstance().getVehiclePosition(internalObjectData.getVehicleID()).setInside(isInside);
    }

    private void checkSpeed(InternalObjectData internalObjectData){
        if(internalObjectData.getSpeed() > speedThreshold){
            SpeedInfractionEvent speedInfractionEvent = new SpeedInfractionEvent(this, internalObjectData);
            applicationEventPublisher.publishEvent(speedInfractionEvent);
        }
    }

    private void checkJerk(InternalObjectData internalObjectData){
        //double jerk = diffAcc/((double)(getOperatingSystem().getSimulationTime()-lastEvent)/(double)TIME.SECOND);
        InternalObjectData pastPosition = VehicleDataShare.getInstance().getVehiclePosition(internalObjectData.getVehicleID());
        double acc = Math.abs(internalObjectData.getAcc() - pastPosition.getAcc());
        long time = internalObjectData.getLastUpdate() - pastPosition.getLastUpdate();

        double jerk = acc/time;

        if(jerk > jerkThreshold){
            JerkInfractionEvent event = new JerkInfractionEvent(this, internalObjectData);
            applicationEventPublisher.publishEvent(event);
        }
    }

}
