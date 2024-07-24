package pt.uminho.infrarob.common.singleton;

import org.eclipse.paho.client.mqttv3.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.UUID;

@Component
public class MqttConnectionShare {

    @Value("${forward.broker.topic:infrarob-data}")
    private String topic;

    @Value("${forward.broker.url}")
    private String brokerURL;
    private static MqttConnectionShare instance = null;
    private IMqttClient mqttClient;
    private MqttConnectOptions options;

    public static MqttConnectionShare getInstance() throws MqttException, IOException {
        if(instance == null){
            instance = new MqttConnectionShare();
        }

        return instance;
    }

    private MqttConnectionShare() throws MqttException, IOException {
        Properties properties = new Properties();
        InputStream inputStream = MqttConnectionShare.class.getClassLoader().getResourceAsStream("application.properties");
        properties.load(inputStream);
        inputStream.close();

        this.topic = properties.getProperty("forward.broker.topic");
        this.brokerURL = properties.getProperty("forward.broker.url");
        this.mqttClient = new MqttClient(brokerURL, UUID.randomUUID().toString());
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
        mqttClient.publish(topic, mqttMessage);
    }
}
