package pt.uminho.infrarob.comms.udpconnector.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.ip.dsl.Udp;
import pt.uminho.infrarob.comms.udpconnector.service.UDPService;

@Configuration
public class UDPIntegrationConfig {
    @Bean
    public UDPService udpService(){
        return new UDPService();
    }

    @Bean
    public IntegrationFlow pocessUdpMessage(){
        return IntegrationFlow
                .from(Udp.inboundAdapter(9000))
                .handle("UDPService","receive")
                .get();
    }
}
