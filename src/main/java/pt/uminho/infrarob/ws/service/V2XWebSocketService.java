package pt.uminho.infrarob.ws.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import pt.uminho.infrarob.common.objects.V2XWarning;
import pt.uminho.infrarob.common.objects.WarningType;
import pt.uminho.infrarob.events.events.JerkInfractionEvent;
import pt.uminho.infrarob.events.events.SafeZoneInfractionEvent;
import pt.uminho.infrarob.events.events.SpeedInfractionEvent;

@Controller
@Service
public class V2XWebSocketService {
    private final String TOPIC = "/topic/safe-zone-infraction";
    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    @Async
    @EventListener
    public void sendSafeZoneInfractionWarning(SafeZoneInfractionEvent event){
        V2XWarning v2XWarning = new V2XWarning("Entitiy outside safe zone", event.getVehiclePosition().toObjectDataWS(), WarningType.SAFEZONE_INFRACION);
        simpMessagingTemplate.convertAndSend(TOPIC,v2XWarning);
    }

    @Async
    @EventListener
    public  void sendSpeedInfractionWarning(SpeedInfractionEvent speedInfractionEvent){
        V2XWarning v2XWarning = new V2XWarning("Excess Speed", speedInfractionEvent.getVehiclePosition().toObjectDataWS(), WarningType.SPEED_INFRACTION);
        simpMessagingTemplate.convertAndSend(TOPIC, v2XWarning);
    }

    @Async
    @EventListener
    public void sendJerkInfractionWarning(JerkInfractionEvent event){
        V2XWarning v2XWarning = new V2XWarning("Jerks warning", event.getVehiclePosition().toObjectDataWS(), WarningType.JERK_INFRACTION);
        simpMessagingTemplate.convertAndSend(TOPIC, v2XWarning);
    }
}