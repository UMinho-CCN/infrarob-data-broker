package pt.uminho.infrarob.events.events;

import org.springframework.context.ApplicationEvent;
import pt.uminho.infrarob.common.objects.PolygonDataSource;
import pt.uminho.infrarob.websocketconnector.objects.PolygonCoordinates;

public class PolygonCoordinateEvent extends ApplicationEvent {
    private PolygonCoordinates polygonCoordinates;
    private PolygonDataSource source;

    public PolygonCoordinateEvent(Object source, PolygonCoordinates polygonCoordinates, PolygonDataSource polygonDataSource) {
        super(source);
        this.polygonCoordinates = polygonCoordinates;
        this.source = polygonDataSource;
    }

    public PolygonCoordinates getPolygonCoordinates() {
        return polygonCoordinates;
    }

    public void setPolygonCoordinates(PolygonCoordinates polygonCoordinates) {
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
