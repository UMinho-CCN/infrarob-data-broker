package pt.uminho.infrarob.events.listners;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Controller;
import pt.uminho.infrarob.common.objects.internal.InternalEventData;
import pt.uminho.infrarob.common.objects.standard.*;
import pt.uminho.infrarob.common.singleton.MqttExternalConnectionShare;
import pt.uminho.infrarob.common.singleton.MqttInternalConnectionShare;
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
        DENMHeader denmHeader = new DENMHeader(2,"denm", 0);

        ActionId actionId = new ActionId(0,0);
        PositionConfidenceEllipse positionConfidenceEllipse = new PositionConfidenceEllipse("doNotUse", "doNotUse", "wgsNorth");
        Altitude altitude = new Altitude("negativeOutOfRange", "alt-000-01");
        EventPosition eventPosition = new EventPosition(eventData.getLat(), eventData.getLon(), positionConfidenceEllipse, altitude);

        DenmManagement denmManagement = new DenmManagement(actionId, outputEvent.getTimestamp(), 0, eventPosition, 600, "unkown");

        EventType eventType = new EventType("collisionRisk97 : collisionRiskWithRoadWorks");

        Situation situation = new Situation(0, eventType);

        PathPosition pathPosition = new PathPosition("unavailable", "unavailable", "negativeOutOfRange");

        DetectionZonesToEventPosition detectionZonesToEventPosition = new DetectionZonesToEventPosition(pathPosition);
        Location location = new Location(detectionZonesToEventPosition);

        ValueConfidence xCoordinate = new ValueConfidence(836, "outOfRange");
        ValueConfidence yCoordinate = new ValueConfidence(-3684, "outOfRange");
        ValueConfidence xVelocity = new ValueConfidence(383, "outOfRange");
        ValueConfidence yVelocity = new ValueConfidence(222, "outOfRange");

        Position position = new Position(xCoordinate, yCoordinate);
        CartesianVelocity velocity = new CartesianVelocity(xVelocity, yVelocity);

        PerceivedPreCrashObject perceivedPreCrashObject = new PerceivedPreCrashObject(-2048, position, velocity);

        ArrayList<PredictedPath> predictedPaths = new ArrayList<>();
        predictedPaths.add(new PredictedPath(100, 0, "unavailable", "unavailable"));
        predictedPaths.add(new PredictedPath(100, 0, "unavailable", "unavailable"));
        predictedPaths.add(new PredictedPath(100, 0, "unavailable", "unavailable"));
        predictedPaths.add(new PredictedPath(100, 0, "unavailable", "unavailable"));

        PredictedPaths predictedPathsObject = new PredictedPaths(predictedPaths, "noIndication", "unavailavle");

        PreCrash preCrash = new PreCrash(perceivedPreCrashObject, 4000, predictedPathsObject);

        Alacarte alacarte = new Alacarte("vehicleSubClass : passengerCar", preCrash);

        DenmBody denmBody = new DenmBody(denmManagement, situation, location, alacarte);

        StandardDENM standardDENM = new StandardDENM(denmHeader, denmBody);

        ObjectMapper mapper = new ObjectMapper();
        try {
            MqttMessage mqttMessage = new MqttMessage(mapper.writeValueAsString(standardDENM).getBytes(StandardCharsets.UTF_8));
            MqttExternalConnectionShare.getInstance().publishToClient(mqttMessage);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

    }
}
