package pt.uminho.infrarob.common.objects.proto2;

import java.util.ArrayList;
import java.util.List;

public class Proto2Objects {
    private double version;
    private int timestamp;
    private List<Proto2ObjectData> objects;
    private List<Proto2Event> events;

    public Proto2Objects() {
        objects = new ArrayList<>();
        events = new ArrayList<>();
    }

    public Proto2Objects(double version, int timestamp, List<Proto2ObjectData> objects, List<Proto2Event> events) {
        this.version = version;
        this.timestamp = timestamp;
        this.objects = objects;
        this.events = events;
    }

    public double getVersion() {
        return version;
    }

    public void setVersion(double version) {
        this.version = version;
    }

    public int getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(int timestamp) {
        this.timestamp = timestamp;
    }

    public List<Proto2ObjectData> getObjects() {
        return objects;
    }

    public void setObjects(List<Proto2ObjectData> objects) {
        this.objects = objects;
    }

    public List<Proto2Event> getEvents() {
        return events;
    }

    public void setEvents(List<Proto2Event> events) {
        this.events = events;
    }

    public void addEvent(Proto2Event event){
        this.events.add(event);
    }

    public  void addData(Proto2ObjectData data){
        this.objects.add(data);
    }




}
