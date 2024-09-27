package pt.uminho.infrarob;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.integration.config.EnableIntegration;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.mqtt.inbound.MqttPahoMessageDrivenChannelAdapter;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import pt.uminho.infrarob.common.objects.internal.InternalObjectData;
import pt.uminho.infrarob.common.objects.proto1.Proto1CAM;
import pt.uminho.infrarob.common.objects.standard.cam.CAMBody;
import pt.uminho.infrarob.common.singleton.MqttExternalConnectionShare;
import pt.uminho.infrarob.events.events.V2XMessageReceivedEvent;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@SpringBootApplication
@EnableIntegration
@EnableScheduling
@EnableAsync
public class MessageBrokerIntegration {
	@Autowired
	private ApplicationEventPublisher applicationEventPublisher;

	public static void main(String[] args) {
		SpringApplication.run(MessageBrokerIntegration.class, args);
	}

	@Bean
	public IntegrationFlow mqttInbound() {
		Properties properties = new Properties();
		InputStream inputStream = MqttExternalConnectionShare.class.getClassLoader().getResourceAsStream("application.properties");

        try {
            properties.load(inputStream);
			inputStream.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


		String topic = properties.getProperty("subscribe.broker.topic");
		String url = properties.getProperty("subscribe.broker.url");
		String clientID = properties.getProperty("subscribe.broker.clientid");
		return IntegrationFlow.from(
						new MqttPahoMessageDrivenChannelAdapter(url,
								clientID, topic))
				.handle(m -> handleMQTT(m.getPayload().toString()))
				.get();
	}

	private void handleMQTT(String data){
		ObjectMapper mapper = new ObjectMapper();
        try {
            CAMBody cam = mapper.readValue(data, CAMBody.class);
			InternalObjectData internalObjectData = cam.toInternalObjectData();
			internalObjectData.setLastUpdate(System.currentTimeMillis());
			V2XMessageReceivedEvent event = new V2XMessageReceivedEvent(this, internalObjectData);
			applicationEventPublisher.publishEvent(event);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
