package pt.uminho.infrarob.udpconnector.service;

import org.eclipse.paho.client.mqttv3.*;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Service;
import pt.uminho.infrarob.common.objects.VehiclePosition;
import pt.uminho.infrarob.common.singleton.MqttConnectionShare;
import pt.uminho.infrarob.common.singleton.VehicleDataShare;

import java.nio.charset.StandardCharsets;
import java.util.UUID;


@Service
public class UDPService {
    private long ID = 0;
    private boolean sendToMQTT = true;
    public void receive(Message message){
        String data = new String((byte[]) message.getPayload());
        String posData[] = data.split(";");
        double lon = Double.parseDouble(posData[1])/10000000;
        double lat = Double.parseDouble(posData[2])/10000000;

        System.out.println("Received Data: " + data);

        VehiclePosition vehiclePosition = new VehiclePosition(posData[0], "", String.valueOf(lat), String.valueOf(lon), System.currentTimeMillis());
        VehicleDataShare.getInstance().addVehiclePosition(vehiclePosition);
        String publisherID = UUID.randomUUID().toString();
        if(sendToMQTT) {
            try {

                MqttMessage mqttMessage = new MqttMessage(vehiclePosition.toStringWithID(ID).getBytes(StandardCharsets.UTF_8));
                MqttConnectionShare.getInstance().publishToClient(mqttMessage);
                ID++;
            } catch (MqttException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
