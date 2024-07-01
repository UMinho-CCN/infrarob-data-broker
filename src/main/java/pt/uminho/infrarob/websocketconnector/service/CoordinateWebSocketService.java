package pt.uminho.infrarob.websocketconnector.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.user.SimpUserRegistry;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import pt.uminho.infrarob.common.objects.V2XWarning;
import pt.uminho.infrarob.common.objects.WarningType;
import pt.uminho.infrarob.common.singleton.PolygonCoordinatesSingleton;
import pt.uminho.infrarob.events.events.BroadcastCoordinatesEvent;
import pt.uminho.infrarob.events.events.SafeZoneInfractionEvent;
import pt.uminho.infrarob.websocketconnector.objects.PolygonCoordinates;

import java.util.List;

@Controller
@Service
public class CoordinateWebSocketService {
    private final String TOPIC = "/topic/polygon-created";
    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    @Async
    @EventListener
    public void sendWarning(BroadcastCoordinatesEvent event){
        List<PolygonCoordinates> polygonCoordinates = PolygonCoordinatesSingleton.getIntance().getCoordinates();
        simpMessagingTemplate.convertAndSend(TOPIC,polygonCoordinates);
    }
}
