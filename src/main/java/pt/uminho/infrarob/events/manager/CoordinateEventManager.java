package pt.uminho.infrarob.events.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import pt.uminho.infrarob.common.singleton.PolygonCoordinatesSingleton;
import pt.uminho.infrarob.events.events.BroadcastCoordinatesEvent;
import pt.uminho.infrarob.events.events.PolygonCoordinateEvent;

@Component
public class CoordinateEventManager {
    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    @Async
    @EventListener
    public void handleReceivedCoordiante(PolygonCoordinateEvent event){
        PolygonCoordinatesSingleton.getIntance().addCoordinate(event.getPolygonCoordinates(), event.getPolygonCoordinates().getPosition());
        BroadcastCoordinatesEvent broadcastCoordinatesEvent = new BroadcastCoordinatesEvent(this);
        applicationEventPublisher.publishEvent(broadcastCoordinatesEvent);
    }
}
