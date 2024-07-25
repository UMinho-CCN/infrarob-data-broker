package pt.uminho.infrarob.common.objects.internal;

import java.util.ArrayList;
import java.util.List;

public class InternalData {
    private List<InternalObjectData> objects;
    private List<InternalEventData> events;
    private List<PolygonCoordinates> coordinates;

    public InternalData(List<InternalObjectData> objects, List<InternalEventData> events, List<PolygonCoordinates> coordinates) {
        this.objects = objects;
        this.events = events;
        this.coordinates = coordinates;
    }

    public InternalData() {
        objects = new ArrayList<>();
        events = new ArrayList<>();
        coordinates = new ArrayList<>();
    }

    public List<InternalObjectData> getObjects() {
        return objects;
    }

    public void setObjects(List<InternalObjectData> objects) {
        this.objects = objects;
    }

    public List<InternalEventData> getEvents() {
        return events;
    }

    public void setEvents(List<InternalEventData> events) {
        this.events = events;
    }

    public List<PolygonCoordinates> getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(List<PolygonCoordinates> coordinates) {
        this.coordinates = coordinates;
    }

    public void addObject(InternalObjectData internalObjectData){
        objects.add(internalObjectData);
    }

    public void addEvents(InternalEventData internalEventData){
        events.add(internalEventData);
    }

    public void addCoordinates(PolygonCoordinates polygonCoordinates){
        coordinates.add(polygonCoordinates);
    }
}
