package pt.uminho.infrarob.common.singleton;

import org.eclipse.paho.client.mqttv3.*;

import java.util.UUID;

public class MqttConnectionShare {
    private final String TOPIC = "infrarob-data";
    private static MqttConnectionShare instance = null;
    private IMqttClient mqttClient;
    private MqttConnectOptions options;

    public static MqttConnectionShare getInstance() throws MqttException {
        if(instance == null){
            instance = new MqttConnectionShare();
        }

        return instance;
    }

    private MqttConnectionShare() throws MqttException {
        this.mqttClient = new MqttClient("tcp://stout.ddns.net:1883", UUID.randomUUID().toString());
        connectMQTT();
    }

    private void connectMQTT() throws MqttException {
        options = new MqttConnectOptions();
        options.setAutomaticReconnect(true);
        options.setCleanSession(true);
        options.setConnectionTimeout(10);
        mqttClient.connect(options);
    }

    public void publishToClient(MqttMessage mqttMessage) throws MqttException {
        mqttClient.publish(TOPIC, mqttMessage);
    }
}
