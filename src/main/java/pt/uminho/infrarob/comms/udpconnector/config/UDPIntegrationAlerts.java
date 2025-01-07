package pt.uminho.infrarob.comms.udpconnector.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.ip.dsl.Udp;
import pt.uminho.infrarob.comms.udpconnector.service.UDPServiceV2X;

@Configuration
public class UDPIntegrationAlerts {
    @Bean
    public UDPServiceV2X udpServiceAlerts(){
        return new UDPServiceV2X();
    }

    @Bean
    public IntegrationFlow pocessUdpMessageAlert(){
        return IntegrationFlow
                .from(Udp.inboundAdapter(9999))
                .handle("UDPServiceAlerts","receive")
                .get();
    }
}
