package pt.uminho.infrarob.events.events;

import org.springframework.context.ApplicationEvent;
import pt.uminho.infrarob.common.objects.PolygonDataSource;
import pt.uminho.infrarob.common.objects.ws.PolygonCoordinatesWS;

public class PolygonCoordinateEvent extends ApplicationEvent {
    private PolygonCoordinatesWS polygonCoordinates;
    private PolygonDataSource source;

    public PolygonCoordinateEvent(Object source, PolygonCoordinatesWS polygonCoordinates, PolygonDataSource polygonDataSource) {
        super(source);
        this.polygonCoordinates = polygonCoordinates;
        this.source = polygonDataSource;
    }

    public PolygonCoordinatesWS getPolygonCoordinates() {
        return polygonCoordinates;
    }

    public void setPolygonCoordinates(PolygonCoordinatesWS polygonCoordinates) {
        this.polygonCoordinates = polygonCoordinates;
    }

    @Override
    public PolygonDataSource getSource() {
        return source;
    }

    public void setSource(PolygonDataSource source) {
        this.source = source;
    }
}
