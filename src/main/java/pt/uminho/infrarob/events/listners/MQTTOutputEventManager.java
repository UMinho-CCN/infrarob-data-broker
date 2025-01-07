package pt.uminho.infrarob.events.listners;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Controller;
import pt.uminho.infrarob.common.objects.internal.InternalObjectData;
import pt.uminho.infrarob.common.objects.proto2.Proto2Objects;
import pt.uminho.infrarob.common.singleton.MqttInternalConnectionShare;
import pt.uminho.infrarob.events.events.V2xMessageOutputEvent;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;

@Controller
@Profile("mqtt")
public class MQTTOutputEventManager {
    @EventListener
    @Async
    public void handleData(V2xMessageOutputEvent outputEvent){
        if(outputEvent.getData().getObjects() != null && !outputEvent.getData().getObjects().isEmpty()){
            handleObjectData(outputEvent);
        }
        if(outputEvent.getData().getObjects() != null && !outputEvent.getData().getEvents().isEmpty()){
            handleEventData(outputEvent);
        }
    }

    private void handleObjectData(V2xMessageOutputEvent outputEvent){
        Proto2Objects proto2Objects = new Proto2Objects();
        for (int i = 0; i < outputEvent.getData().getObjects().size(); i++) {
            InternalObjectData internalObjectData = outputEvent.getData().getObjects().get(i);
            proto2Objects.addData(internalObjectData.toProto2ObjectData());
        }

        ObjectMapper mapper = new ObjectMapper();
        try {
            MqttMessage mqttMessage = new MqttMessage(mapper.writeValueAsString(proto2Objects).getBytes(StandardCharsets.UTF_8));
            MqttInternalConnectionShare.getInstance().publishToClient(mqttMessage);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void handleEventData(V2xMessageOutputEvent outputEvent){
        Proto2Objects proto2Objects = new Proto2Objects();
        proto2Objects.addEvent(outputEvent.getData().getEvents().get(0).toProto2Event());

        List<InternalObjectData> objects = outputEvent.getData().getObjects();

        for (int i = 0; i < objects.size(); i++) {
            InternalObjectData internalObjectData = objects.get(i);
            proto2Objects.addData(internalObjectData.toProto2ObjectData());
        }

        ObjectMapper mapper = new ObjectMapper();
        try {
            MqttMessage mqttMessage = new MqttMessage(mapper.writeValueAsString(proto2Objects).getBytes(StandardCharsets.UTF_8));
            MqttInternalConnectionShare.getInstance().publishToClient(mqttMessage);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
