package pt.uminho.infrarob.events.events;

import org.springframework.context.ApplicationEvent;
import pt.uminho.infrarob.common.objects.internal.InternalObjectData;

public class SafeZoneInfractionEvent extends ApplicationEvent {
    private InternalObjectData internalObjectData;

    public SafeZoneInfractionEvent(Object source, InternalObjectData internalObjectData) {
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
