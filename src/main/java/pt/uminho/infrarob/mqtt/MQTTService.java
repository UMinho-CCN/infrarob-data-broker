package pt.uminho.infrarob.mqtt;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import pt.uminho.infrarob.common.objects.internal.InternalEventData;
import pt.uminho.infrarob.common.objects.internal.InternalObjectData;
import pt.uminho.infrarob.common.objects.proto2.Proto2Event;
import pt.uminho.infrarob.common.objects.proto2.Proto2ObjectData;
import pt.uminho.infrarob.common.objects.proto2.Proto2Objects;
import pt.uminho.infrarob.common.singleton.MqttConnectionShare;
import pt.uminho.infrarob.common.singleton.VehicleDataShare;
import pt.uminho.infrarob.events.events.MQTTEvent;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

@Controller
@Service
public class MQTTService {
    @Async
    @EventListener
    public void sendToMQTT(MQTTEvent mqttEvent){

        Proto2Objects proto2Objects = new Proto2Objects();
        List<Proto2ObjectData> objectsList = new ArrayList<>();
        proto2Objects.setObjects(objectsList);
        if(mqttEvent.getObjectData()  != null){
            proto2Objects.addData(mqttEvent.getObjectData().toProto2ObjectData());
        }

        if (mqttEvent.getEventData() != null){
            List<InternalObjectData> objectDataList = VehicleDataShare.getInstance().getList();
            proto2Objects.addEvent(mqttEvent.getEventData().toProto2Event());
            for (int i = 0; i < objectDataList.size(); i++) {
                InternalObjectData internalObjectData = objectDataList.get(i);
                objectsList.add(internalObjectData.toProto2ObjectData());
            }
        }

        ObjectMapper mapper = new ObjectMapper();

        MqttMessage mqttMessage = null;
        try {
            mqttMessage = new MqttMessage(mapper.writeValueAsString(proto2Objects).getBytes(StandardCharsets.UTF_8));
            MqttConnectionShare.getInstance().publishToClient(mqttMessage);
        } catch (MqttException | IOException e) {
            throw new RuntimeException(e);
        }

    }
}
