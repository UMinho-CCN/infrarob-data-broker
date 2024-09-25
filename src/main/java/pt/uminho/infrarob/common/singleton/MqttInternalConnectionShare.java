package pt.uminho.infrarob.common.singleton;

import org.eclipse.paho.client.mqttv3.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.UUID;

@Component
public class MqttInternalConnectionShare {

    @Value("${forward.broker.topic:infrarob-data}")
    private String topic;

    @Value("${forward.broker.url}")
    private String brokerURL;
    private static MqttInternalConnectionShare instance = null;
    private IMqttClient mqttClient;
    private MqttConnectOptions options;

    public static MqttInternalConnectionShare getInstance() {
        if(instance == null){
            instance = new MqttInternalConnectionShare();
        }

        return instance;
    }

    private MqttInternalConnectionShare() {
        Properties properties = new Properties();
        InputStream inputStream = MqttInternalConnectionShare.class.getClassLoader().getResourceAsStream("application.properties");
        try {
            properties.load(inputStream);
            inputStream.close();

            this.topic = properties.getProperty("forward.broker.topic");
            this.brokerURL = properties.getProperty("forward.broker.url");
            this.mqttClient = new MqttClient(brokerURL, UUID.randomUUID().toString());
            connectMQTT();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (MqttException e) {
            throw new RuntimeException(e);
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
            throw new RuntimeException(e);
        }
    }

    public void publishToClient(MqttMessage mqttMessage) {
        try {
            mqttClient.publish(topic, mqttMessage);
        } catch (MqttException e) {
            throw new RuntimeException(e);
        }
    }
}
