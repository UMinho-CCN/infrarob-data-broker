package pt.uminho.infrarob.websocketconnector.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.user.SimpUser;
import org.springframework.messaging.simp.user.SimpUserRegistry;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import pt.uminho.infrarob.common.objects.V2XWarning;
import pt.uminho.infrarob.common.objects.VehiclePosition;
import pt.uminho.infrarob.common.objects.WarningType;
import pt.uminho.infrarob.events.events.SafeZoneInfractionEvent;

import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@Service
public class WebSocketService {
    private final String TOPIC = "/topic/safe-zone-infraction";
    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;


    @Autowired
    private SimpUserRegistry simpUserRegistry;

    @Async
    @EventListener
    public void sendWarning(SafeZoneInfractionEvent event){
        V2XWarning v2XWarning = new V2XWarning("Entitiy outside safe zone", event.getVehiclePosition(), WarningType.SAFEZONE_INFRACION);
        simpMessagingTemplate.convertAndSend(TOPIC,v2XWarning);
    }
}
