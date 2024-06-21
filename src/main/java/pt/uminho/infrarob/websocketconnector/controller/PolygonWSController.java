package pt.uminho.infrarob.websocketconnector.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;
import pt.uminho.infrarob.common.objects.PolygonDataSource;
import pt.uminho.infrarob.common.singleton.PolygonCoordinatesSingleton;
import pt.uminho.infrarob.events.events.BroadcastCoordinatesEvent;
import pt.uminho.infrarob.events.events.PolygonCoordinateEvent;
import pt.uminho.infrarob.websocketconnector.objects.PolygonCoordinates;

import java.util.List;

@Controller
public class PolygonWSController {
    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    @Value("${polygon.source:web}")
    private PolygonDataSource polygonSource;
    @MessageMapping("/poylgon-coordinates")
    //@SendTo("/topic/polygon-created")
    public void setPolygonCoordinates(PolygonCoordinates coordinate){
        if(polygonSource != PolygonDataSource.WEB){
            return;
        }
        PolygonCoordinateEvent polygonCoordinateEvent = new PolygonCoordinateEvent(this, coordinate, PolygonDataSource.WEB);
        applicationEventPublisher.publishEvent(polygonCoordinateEvent);
    }

    @MessageMapping("/poylgon-coordinates-get")
    //@SendTo("/topic/polygon-created")
    public void getPolygonCoordinates(){
        BroadcastCoordinatesEvent event = new BroadcastCoordinatesEvent(this);
        applicationEventPublisher.publishEvent(event);

    }
}
