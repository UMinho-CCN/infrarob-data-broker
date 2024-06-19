package pt.uminho.infrarob.udpconnector.service;

import org.eclipse.paho.client.mqttv3.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Service;
import pt.uminho.infrarob.common.objects.VehiclePosition;
import pt.uminho.infrarob.common.singleton.MqttConnectionShare;
import pt.uminho.infrarob.common.singleton.VehicleDataShare;
import pt.uminho.infrarob.events.events.V2XMessageReceivedEvent;

import java.nio.charset.StandardCharsets;
import java.util.UUID;


@Service
public class UDPService {
    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;
    private long ID = 0;
    private boolean sendToMQTT = true;
    public void receive(Message message){
        String data = new String((byte[]) message.getPayload());
        String posData[] = data.split(";");
        double lon = Double.parseDouble(posData[2]);///10000000;
        double lat = Double.parseDouble(posData[1]);///10000000;

        VehiclePosition vehiclePosition = new VehiclePosition(posData[0], "", String.valueOf(lat), String.valueOf(lon), System.currentTimeMillis(), false);

        V2XMessageReceivedEvent event = new V2XMessageReceivedEvent(this, vehiclePosition, true, sendToMQTT);
        applicationEventPublisher.publishEvent(event);
    }
}
