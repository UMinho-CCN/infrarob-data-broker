package pt.uminho.infrarob.events.events;

import org.springframework.context.ApplicationEvent;

public class BroadcastCoordinatesEvent extends ApplicationEvent {

    public BroadcastCoordinatesEvent(Object source) {
        super(source);
    }
}
