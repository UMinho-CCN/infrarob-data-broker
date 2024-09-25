package pt.uminho.infrarob.comms.ws.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.event.SimpleApplicationEventMulticaster;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;
import pt.uminho.infrarob.common.objects.enums.PolygonDataSource;
import pt.uminho.infrarob.common.objects.internal.InternalData;
import pt.uminho.infrarob.common.objects.internal.PolygonCoordinates;
import pt.uminho.infrarob.common.singleton.PolygonCoordinatesSingleton;
import pt.uminho.infrarob.events.events.V2xMessageOutputEvent;
import pt.uminho.infrarob.events.events.WSOutputEvent;

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
        InternalData data = new InternalData();
        data.addCoordinates(coordinate);
        PolygonCoordinatesSingleton.getIntance().addCoordinate(coordinate, false);

        InternalData aux = new InternalData(null, null, PolygonCoordinatesSingleton.getIntance().getCoordinates());

        V2xMessageOutputEvent outputEvent = new V2xMessageOutputEvent(this, aux);
        applicationEventPublisher.publishEvent(outputEvent);
    }

    @MessageMapping("/poylgon-coordinates-get")
    //@SendTo("/topic/polygon-created")
    public void getPolygonCoordinates(){
        List<PolygonCoordinates> polygonCoordinates = PolygonCoordinatesSingleton.getIntance().getCoordinates();
        InternalData data = new InternalData();
        data.setCoordinates(polygonCoordinates);
        V2xMessageOutputEvent outputEvent = new V2xMessageOutputEvent(this, data);
        applicationEventPublisher.publishEvent(outputEvent);

    }
}
