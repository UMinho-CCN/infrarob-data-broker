package pt.uminho.infrarob.common.singleton;

import pt.uminho.infrarob.common.objects.internal.PolygonCoordinates;

import java.awt.geom.Path2D;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class PolygonCoordinatesSingleton {
    ReadWriteLock lock = new ReentrantReadWriteLock();
    Lock writeLock =  lock.writeLock();
    Lock readLock = lock.readLock();
    static private PolygonCoordinatesSingleton instance = null;
    private List<PolygonCoordinates> polygonCoordinates;
    private Path2D path2D;


    private PolygonCoordinatesSingleton() {
        this.polygonCoordinates = new ArrayList<>();
        path2D = new Path2D.Double();
    }

    public static PolygonCoordinatesSingleton getIntance(){
        if (instance == null){
            instance = new PolygonCoordinatesSingleton();
        }

        return instance;
    }

    public void addCoordinates(List<PolygonCoordinates> polygonCoordinates){
        this.polygonCoordinates = polygonCoordinates;
        createPath();
    }


    public void addCoordinate(PolygonCoordinates polygonCoordinates){
        try {
            writeLock.lock();
            if (this.polygonCoordinates.size() >= 4) {
                this.polygonCoordinates = new ArrayList<>();
            }
            this.polygonCoordinates.add(polygonCoordinates);
            Collections.sort(this.polygonCoordinates, Comparator.comparingInt(PolygonCoordinates::getPosition));
            if (this.polygonCoordinates.size() > 2) {
                createPath();
            }
        }finally {
            writeLock.unlock();
        }
    }

    private void createPath(){
        path2D = new Path2D.Double();

        for (int i = 0; i < this.polygonCoordinates.size(); i++) {
            PolygonCoordinates coordinates = this.polygonCoordinates.get(i);
            if(i == 0){
                path2D.moveTo(coordinates.getLat(), coordinates.getLng());
            }else{
                path2D.lineTo(coordinates.getLat(), coordinates.getLng());
            }
        }
    }

    public boolean isInside(double lat, double lng){
        return path2D.contains(new Point2D.Double(lat, lng));
    }

    public List<PolygonCoordinates> getCoordinates(){
        return this.polygonCoordinates;
    }
}
