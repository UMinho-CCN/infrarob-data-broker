package pt.uminho.infrarob.events.events;

import org.springframework.context.ApplicationEvent;
import pt.uminho.infrarob.common.objects.internal.InternalObjectData;

public class V2XMessageReceivedEvent extends ApplicationEvent {
    private InternalObjectData internalObjectData;

    public V2XMessageReceivedEvent(Object source, InternalObjectData internalObjectData) {
        super(source);
        this.internalObjectData = internalObjectData;
    }

    public InternalObjectData getVehiclePosition() {
        return internalObjectData;
    }

    public void setVehiclePosition(InternalObjectData internalObjectData) {
        this.internalObjectData = internalObjectData;
    }

}
