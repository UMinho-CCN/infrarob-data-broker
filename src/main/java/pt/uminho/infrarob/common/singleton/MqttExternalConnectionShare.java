package pt.uminho.infrarob.common.singleton;

import org.eclipse.paho.client.mqttv3.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.UUID;

@Component
public class MqttExternalConnectionShare {

    @Value("${forward.broker.external.topic:infrarob-data-external}")
    private String topic;

    @Value("${forward.broker.external.url}")
    private String brokerURL;
    private static MqttExternalConnectionShare instance = null;
    private IMqttClient mqttClient;
    private MqttConnectOptions options;

    public static MqttExternalConnectionShare getInstance() {
        if(instance == null){
            instance = new MqttExternalConnectionShare();
        }

        return instance;
    }

    private MqttExternalConnectionShare() {
        Properties properties = new Properties();
        InputStream inputStream = MqttExternalConnectionShare.class.getClassLoader().getResourceAsStream("application.properties");
        try {
            properties.load(inputStream);
            inputStream.close();

            this.topic = properties.getProperty("forward.broker.external.topic");
            this.brokerURL = properties.getProperty("forward.broker.external.url");
            this.mqttClient = new MqttClient(brokerURL, UUID.randomUUID().toString());
            connectMQTT();
        } catch (MqttException | IOException e) {
            e.printStackTrace();
        }

    }

    private void connectMQTT() {
        options = new MqttConnectOptions();
        options.setAutomaticReconnect(true);
        options.setCleanSession(true);
        options.setConnectionTimeout(10);
        try {
            mqttClient.connect(options);
        } catch (MqttException e) {
            e.printStackTrace();
        }
    }

    public void publishToClient(MqttMessage mqttMessage) {
        try {
            mqttClient.publish(topic, mqttMessage);
        } catch (MqttException e) {
            e.printStackTrace();
        }
    }
}
