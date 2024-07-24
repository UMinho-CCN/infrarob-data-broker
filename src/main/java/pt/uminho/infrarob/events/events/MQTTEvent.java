package pt.uminho.infrarob.events.events;

import org.springframework.context.ApplicationEvent;
import pt.uminho.infrarob.common.objects.internal.InternalEventData;
import pt.uminho.infrarob.common.objects.internal.InternalObjectData;

public class MQTTEvent extends ApplicationEvent {
    private InternalObjectData objectData;
    private InternalEventData eventData;

    public MQTTEvent(Object source, InternalObjectData objectData, InternalEventData eventData) {
        super(source);
        this.objectData = objectData;
        this.eventData = eventData;
    }

    public InternalObjectData getObjectData() {
        return objectData;
    }

    public void setObjectData(InternalObjectData objectData) {
        this.objectData = objectData;
    }

    public InternalEventData getEventData() {
        return eventData;
    }

    public void setEventData(InternalEventData eventData) {
        this.eventData = eventData;
    }

    @Override
    public String toString() {
        return "MQTTEvent{" +
                "objectData=" + objectData +
                ", eventData=" + eventData +
                '}';
    }
}
