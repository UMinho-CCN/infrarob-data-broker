package pt.uminho.infrarob;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.integration.config.EnableIntegration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableIntegration
@EnableScheduling
@EnableAsync
public class MessageBrokerIntegration {


	public static void main(String[] args) {
		SpringApplication.run(MessageBrokerIntegration.class, args);
	}
}
