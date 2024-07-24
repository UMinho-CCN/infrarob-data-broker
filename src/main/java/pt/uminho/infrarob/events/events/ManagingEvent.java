package pt.uminho.infrarob.events.events;

import org.springframework.context.ApplicationEvent;
import pt.uminho.infrarob.common.objects.internal.InternalEventData;
import pt.uminho.infrarob.common.objects.internal.InternalObjectData;
import pt.uminho.infrarob.common.objects.ws.PolygonCoordinatesWS;

public class ManagingEvent extends ApplicationEvent {
    private InternalObjectData internalObjectData;
    private InternalEventData eventData;

    private PolygonCoordinatesWS polygonCoordinatesWS;

    public ManagingEvent(Object source, InternalObjectData internalObjectData, InternalEventData eventData, PolygonCoordinatesWS polygonCoordinatesWS) {
        super(source);
        this.internalObjectData = internalObjectData;
        this.eventData = eventData;
        this.polygonCoordinatesWS = polygonCoordinatesWS;
    }

    public InternalObjectData getInternalObjectData() {
        return internalObjectData;
    }

    public void setInternalObjectData(InternalObjectData internalObjectData) {
        this.internalObjectData = internalObjectData;
    }

    public InternalEventData getEventData() {
        return eventData;
    }

    public void setEventData(InternalEventData eventData) {
        this.eventData = eventData;
    }

    public PolygonCoordinatesWS getPolygonCoordinatesWS() {
        return polygonCoordinatesWS;
    }

    public void setPolygonCoordinatesWS(PolygonCoordinatesWS polygonCoordinatesWS) {
        this.polygonCoordinatesWS = polygonCoordinatesWS;
    }
}
