package pt.uminho.infrarob.events.initialization;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import pt.uminho.infrarob.common.objects.PolygonDataSource;
import pt.uminho.infrarob.common.singleton.PolygonCoordinatesSingleton;
import pt.uminho.infrarob.events.events.PolygonCoordinateEvent;
import pt.uminho.infrarob.websocketconnector.objects.PolygonCoordinates;

import java.util.logging.Logger;


@Component
public class PostConstructInit {

    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    private static final Logger LOG = Logger.getLogger(PostConstructInit.class.getName());

    @Value("${polygon.source:web}")
    private PolygonDataSource polygonSource;

    @Value("${polygon.lat}")
    private String[] lat;

    @Value("${polygon.lng}")
    private String[] lng;

    @PostConstruct
    public void init(){
        LOG.info("Polygon data source: " + polygonSource);
        if(polygonSource != PolygonDataSource.CONFIG_FILE){
            return;
        }
        for (int i = 0; i < lat.length; i++) {
            String lats = lat[i];
            String lngs = lng[i];
            PolygonCoordinates polygonCoordinates = new PolygonCoordinates(Double.parseDouble(lats), Double.parseDouble(lngs));
            PolygonCoordinateEvent polygonCoordinateEvent = new PolygonCoordinateEvent(this,polygonCoordinates, PolygonDataSource.CONFIG_FILE);
            PolygonCoordinatesSingleton.getIntance().addCoordinate(polygonCoordinates);
        }
    }
}
