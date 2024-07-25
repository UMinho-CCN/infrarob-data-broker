package pt.uminho.infrarob.events.listners;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.event.EventListener;
import org.springframework.context.event.SimpleApplicationEventMulticaster;
import org.springframework.core.annotation.Order;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import pt.uminho.infrarob.common.objects.enums.Brokers;
import pt.uminho.infrarob.common.objects.enums.InfractionType;
import pt.uminho.infrarob.common.objects.internal.InternalData;
import pt.uminho.infrarob.common.objects.internal.InternalEventData;
import pt.uminho.infrarob.common.objects.internal.InternalObjectData;
import pt.uminho.infrarob.common.objects.enums.PolygonDataSource;
import pt.uminho.infrarob.common.objects.internal.PolygonCoordinates;
import pt.uminho.infrarob.common.singleton.PolygonCoordinatesSingleton;
import pt.uminho.infrarob.common.singleton.VehicleDataShare;
import pt.uminho.infrarob.events.events.*;

import java.util.Arrays;
import java.util.List;

@Component
public class V2XInputEventManager {

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

    @Value("${forward.brokers:WS}")
    private Brokers broker;

    @Value(("${infraction.speed}"))
    private int speedThreshold;

    @Value(("${infraction.jerks}"))
    private int jerkThreshold;

    @Async
    @EventListener
    @Order(1)
    public void handleForwarding(V2XMessageReceivedEvent message){
        InternalObjectData internalObjectData = message.getVehiclePosition();
        VehicleDataShare.getInstance().addVehiclePosition(internalObjectData);

        InternalData data = new InternalData();
        data.addObject(internalObjectData);
        applicationEventPublisher.publishEvent(new V2xMessageOutputEvent(this, data));
    }


    @Async
    @EventListener
    @Order(10)
    public void handlePolygon(V2XMessageReceivedEvent message){
        if(polygonSource == PolygonDataSource.V2X){
            List<String> srcs = Arrays.asList(polygonSRCs);
            int stationIndex = srcs.indexOf(message.getVehiclePosition().getVehicleID());
            InternalData data = new InternalData();

            if(stationIndex >= 0){

                PolygonCoordinates polygonCoordinates = new PolygonCoordinates(
                        message.getVehiclePosition().getConvertedLat(),
                        message.getVehiclePosition().getConvertedLon(),
                        stationIndex);
                data.addCoordinates(polygonCoordinates);
                PolygonCoordinatesSingleton.getIntance().addCoordinate(polygonCoordinates);
                applicationEventPublisher.publishEvent(new V2xMessageOutputEvent(this, data));
            }
        }
    }

    @Async
    @EventListener
    @Order(10)
    public void handleSafeZone(V2XMessageReceivedEvent message) {
        if(polygonSource == PolygonDataSource.V2X){
            if(Arrays.asList(polygonSRCs).contains(message.getVehiclePosition().getVehicleID())){
                return;
            }
        }
        InternalData data;

        boolean isInside = PolygonCoordinatesSingleton.getIntance().isInside(
                message.getVehiclePosition().getConvertedLat(),
                message.getVehiclePosition().getConvertedLon());

        InternalObjectData pastPosition = VehicleDataShare.getInstance().getVehiclePosition(message.getVehiclePosition().getVehicleID());

        boolean pastInside = pastPosition == null ? isInside : pastPosition.isInside();
        //System.out.println("inside: " + isInside + " past: " + pastInside);
        if (pastInside && !isInside) {
            data = new InternalData();
            data.addEvents(new InternalEventData(
                    1,
                    InfractionType.SAFEZONE_INFRACION,
                    "PLATFORM",
                    message.getVehiclePosition().getLat(),
                    message.getVehiclePosition().getLon(),
                    message.getVehiclePosition().getAltitude(),
                    100
            ));
            data.addObject(message.getVehiclePosition());
            applicationEventPublisher.publishEvent(new V2xMessageOutputEvent(this, data));
        }

        VehicleDataShare.getInstance().getVehiclePosition(message.getVehiclePosition().getVehicleID()).setInside(isInside);
    }




    @Async
    @EventListener
    @Order(10)
    public void checkSpeed(V2XMessageReceivedEvent message){
        if(message.getVehiclePosition().getSpeed() > speedThreshold){
            InternalData data = new InternalData();
            data.addEvents(new InternalEventData(
                    1,
                    InfractionType.SPEED_INFRACTION,
                    "PLATFORM",
                    message.getVehiclePosition().getLat(),
                    message.getVehiclePosition().getLon(),
                    message.getVehiclePosition().getAltitude(),
                    100
            ));
            data.addObject(message.getVehiclePosition());
            applicationEventPublisher.publishEvent(new V2xMessageOutputEvent(this, data));
        }
    }

    @Async
    @EventListener
    @Order(10)
    public void checkJerk(V2XMessageReceivedEvent message){
        InternalObjectData pastPosition = VehicleDataShare.getInstance().getVehiclePosition(message.getVehiclePosition().getVehicleID());

        if(pastPosition == null) return;

        double acc = Math.abs(message.getVehiclePosition().getAcc() - pastPosition.getAcc());
        long time = message.getVehiclePosition().getLastUpdate() - pastPosition.getLastUpdate();

        double jerk = acc/time;

        if(jerk > jerkThreshold){
            InternalData data = new InternalData();
            data.addEvents(new InternalEventData(
                    1,
                    InfractionType.JERK_INFRACTION,
                    "PLATFORM",
                    message.getVehiclePosition().getLat(),
                    message.getVehiclePosition().getLon(),
                    message.getVehiclePosition().getAltitude(),
                    100
            ));
            data.addObject(message.getVehiclePosition());
            applicationEventPublisher.publishEvent(new V2xMessageOutputEvent(this, data));
        }
    }

}
