package pt.uminho.infrarob.events.listners;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Controller;
import pt.uminho.infrarob.common.objects.enums.InfractionType;
import pt.uminho.infrarob.common.objects.internal.InternalObjectData;
import pt.uminho.infrarob.common.objects.internal.PolygonCoordinates;
import pt.uminho.infrarob.common.objects.ws.ObjectDataWS;
import pt.uminho.infrarob.common.objects.ws.PolygonCoordinatesWS;
import pt.uminho.infrarob.common.objects.ws.WSWarning;
import pt.uminho.infrarob.common.singleton.PolygonCoordinatesSingleton;
import pt.uminho.infrarob.events.events.V2xMessageOutputEvent;

import java.util.ArrayList;
import java.util.List;

@Controller
@Profile("ws")
public class WSOutputEventManager {

    private final String POLYGON_TOPIC = "/topic/polygon-created";
    private final String INFRACTION_TOPIC = "/topic/safe-zone-infraction";
    private final String OBJECT_TOPIC = "/topic/positioning-data";
    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    @Value("${forward.brokers.ws:true}")
    private boolean active;
    @EventListener
    @Async
    public void handleData(V2xMessageOutputEvent outputEvent) {
        if(outputEvent.getData().getObjects() != null && !outputEvent.getData().getObjects().isEmpty()){
            handleObjectData(outputEvent);
        }
        if(outputEvent.getData().getObjects() != null && !outputEvent.getData().getEvents().isEmpty()){
            handleEventData(outputEvent);
        }
        if(outputEvent.getData().getCoordinates() != null && !outputEvent.getData().getCoordinates().isEmpty()){
            handlePolygonData(outputEvent);
        }
    }

    private void handleObjectData(V2xMessageOutputEvent outputEvent){
        List<ObjectDataWS> positionList = new ArrayList<>();
        for (int i = 0; i < outputEvent.getData().getObjects().size(); i++) {
            InternalObjectData internalObjectData = outputEvent.getData().getObjects().get(i);
            positionList.add(internalObjectData.toObjectDataWS());
        }
        simpMessagingTemplate.convertAndSend(OBJECT_TOPIC,positionList);
    }

    private void handleEventData(V2xMessageOutputEvent outputEvent){
        if(outputEvent.getData().getEvents() == null){
            return;
        }
        WSWarning wsWarning;
        switch (outputEvent.getData().getEvents().get(0).getEventType()){
            case SAFEZONE_INFRACION -> wsWarning = new WSWarning("Entity outside safe zone", outputEvent.getData().getObjects().get(0).toObjectDataWS(), InfractionType.SAFEZONE_INFRACION);
            case SPEED_INFRACTION -> wsWarning = new WSWarning("Speeding", outputEvent.getData().getObjects().get(0).toObjectDataWS(), InfractionType.SPEED_INFRACTION);
            case JERK_INFRACTION -> wsWarning = new WSWarning("Jerk Detected", outputEvent.getData().getObjects().get(0).toObjectDataWS(), InfractionType.JERK_INFRACTION);
            default -> wsWarning = new WSWarning("Other", outputEvent.getData().getObjects().get(0).toObjectDataWS(), InfractionType.UNKNOWN);
        }

        simpMessagingTemplate.convertAndSend(INFRACTION_TOPIC,wsWarning);
    }

    private void handlePolygonData(V2xMessageOutputEvent outputEvent){
        if(outputEvent.getData().getCoordinates() == null){
            return;
        }
        List<PolygonCoordinatesWS> coordinatesWS = new ArrayList<>();
        for (int i = 0; i < PolygonCoordinatesSingleton.getIntance().getCoordinates().size(); i++) {
            PolygonCoordinates polygonCoordinates = PolygonCoordinatesSingleton.getIntance().getCoordinates().get(i);
            coordinatesWS.add(polygonCoordinates.toPolygonCoordinatesWS());
        }
        simpMessagingTemplate.convertAndSend(POLYGON_TOPIC,coordinatesWS);
    }
}
