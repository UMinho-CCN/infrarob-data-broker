package pt.uminho.infrarob.events.events;

import org.springframework.context.ApplicationEvent;

public class RequestRESTDataEvent extends ApplicationEvent {

    public RequestRESTDataEvent(Object source) {
        super(source);
    }
}
