package pt.uminho.infrarob.ws.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import pt.uminho.infrarob.common.singleton.PolygonCoordinatesSingleton;
import pt.uminho.infrarob.events.events.BroadcastCoordinatesEvent;
import pt.uminho.infrarob.common.objects.ws.PolygonCoordinatesWS;

import java.util.List;

@Controller
@Service
public class PolygonWebSocketService {
    private final String TOPIC = "/topic/polygon-created";
    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    @Async
    @EventListener
    public void sendPolygon(BroadcastCoordinatesEvent event){
        List<PolygonCoordinatesWS> polygonCoordinates = PolygonCoordinatesSingleton.getIntance().getCoordinates();
        simpMessagingTemplate.convertAndSend(TOPIC,polygonCoordinates);
    }
}
