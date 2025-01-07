package pt.uminho.infrarob.events.listners;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Controller;
import pt.uminho.infrarob.common.objects.enums.InfractionType;
import pt.uminho.infrarob.common.objects.internal.InternalEventData;
import pt.uminho.infrarob.common.objects.standard.denm.*;
import pt.uminho.infrarob.common.singleton.MqttExternalConnectionShare;
import pt.uminho.infrarob.events.events.V2xMessageOutputEvent;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

@Controller
@Profile("infrastructure")
public class DenmOutputEventManager {
    @EventListener
    @Async
    public void handleData(V2xMessageOutputEvent outputEvent){
        if(outputEvent.getData().getObjects() == null || outputEvent.getData().getEvents().isEmpty()){
            return;
        }
        InternalEventData eventData = outputEvent.getData().getEvents().get(0);
        DENMHeader denmHeader = new DENMHeader(2,1, 0);

        ActionId actionId = new ActionId(0,0);
        PositionConfidenceEllipse positionConfidenceEllipse = new PositionConfidenceEllipse(0, 0, 0);
        Altitude altitude = new Altitude(0, "alt-000-01");
        EventPosition eventPosition = new EventPosition(eventData.getLat(), eventData.getLon(), positionConfidenceEllipse, altitude);

        DenmManagement denmManagement = new DenmManagement(actionId, outputEvent.getTimestamp(), 0, eventPosition, 10, 0);
        EventType eventType = new EventType(new DenmCCAndSCC(8));;
        if(outputEvent.getData().getEvents().get(0).getEventType() == InfractionType.SAFEZONE_INFRACION) {
            //worker
            //eventType = new EventType(new DenmCCAndSCC(4));
            //deviating machine
            eventType = new EventType(new DenmCCAndSCC(9));
        }else if(outputEvent.getData().getEvents().get(0).getEventType() == InfractionType.SPEED_INFRACTION){
            //speeding
            eventType = new EventType(new DenmCCAndSCC(8));
        }

        ArrayList<PredictedPath> predictedPaths = new ArrayList<>();

        ValueConfidence xCoordinate = new ValueConfidence(836, 4095);
        ValueConfidence yCoordinate = new ValueConfidence(-3684, 4095);
        ValueConfidence xVelocity = new ValueConfidence(383, 1026);
        ValueConfidence yVelocity = new ValueConfidence(222, 1026);

        Position position = new Position(xCoordinate, yCoordinate);
        CartesianVelocity velocity = new CartesianVelocity(xVelocity, yVelocity);

        PerceivedPreCrashObject perceivedPreCrashObject = new PerceivedPreCrashObject(-2048, position, velocity);

        PredictedPaths predictedPathsObject = new PredictedPaths(predictedPaths, "noIndication", "unavailable");

        PreCrash preCrash = new PreCrash(perceivedPreCrashObject, 4000);

        Alacarte alacarte = new Alacarte(new DenmCollisionObject(5), preCrash);

        Situation situation = new Situation(0, eventType);

        PathPosition pathPosition = new PathPosition(100, 100, 0);

        DetectionZonesToEventPosition detectionZonesToEventPosition = new DetectionZonesToEventPosition(pathPosition);
        ArrayList<ArrayList<DetectionZonesToEventPosition>> zones = new ArrayList<>();
        ArrayList<DetectionZonesToEventPosition> zone = new ArrayList<>();
        zone.add(detectionZonesToEventPosition);
        zones.add(new ArrayList<>(zone));
        Location location = new Location(zones);




        DenmBody denmBody = new DenmBody(denmManagement, situation, location);

        StandardDENM standardDENM = new StandardDENM(denmHeader, denmBody);

        ObjectMapper mapper = new ObjectMapper();
        try {
            System.out.println("DEMN: " + mapper.writeValueAsString(standardDENM));
            MqttMessage mqttMessage = new MqttMessage(mapper.writeValueAsString(standardDENM).getBytes(StandardCharsets.UTF_8));
            MqttExternalConnectionShare.getInstance().publishToClient(mqttMessage);

        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

    }
}
