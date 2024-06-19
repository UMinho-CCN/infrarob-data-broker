package pt.uminho.infrarob.common.singleton;

import pt.uminho.infrarob.websocketconnector.objects.PolygonCoordinates;

import java.util.ArrayList;
import java.util.List;

public class PolygonCoordinatesSingleton {
    static private PolygonCoordinatesSingleton instance = null;
    private List<PolygonCoordinates> polygonCoordinates;

    private PolygonCoordinatesSingleton() {
        this.polygonCoordinates = new ArrayList<>();
    }

    public static PolygonCoordinatesSingleton getIntance(){
        if (instance == null){
            instance = new PolygonCoordinatesSingleton();
        }

        return instance;
    }

    public void addCoordinates(List<PolygonCoordinates> polygonCoordinates){
        this.polygonCoordinates = polygonCoordinates;
    }

    public List<PolygonCoordinates> getCoordinates(){
        return this.polygonCoordinates;
    }
}
