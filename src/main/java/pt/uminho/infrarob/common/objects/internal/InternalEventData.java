package pt.uminho.infrarob.common.objects.internal;

import pt.uminho.infrarob.common.objects.proto2.Proto2Event;

public class InternalEventData {
    private int eventID;
    private String eventType;
    private String origin;
    private int lat;
    private int lon;
    private int altitude;
    private int radius;

    public InternalEventData() {
    }

    public InternalEventData(int eventID, String eventType, String origin, int lat, int lon, int altitude, int radius) {
        this.eventID = eventID;
        this.eventType = eventType;
        this.origin = origin;
        this.lat = lat;
        this.lon = lon;
        this.altitude = altitude;
        this.radius = radius;
    }

    public int getEventID() {
        return eventID;
    }

    public void setEventID(int eventID) {
        this.eventID = eventID;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public int getLat() {
        return lat;
    }

    public void setLat(int lat) {
        this.lat = lat;
    }

    public int getLon() {
        return lon;
    }

    public void setLon(int lon) {
        this.lon = lon;
    }

    public int getAltitude() {
        return altitude;
    }

    public void setAltitude(int altitude) {
        this.altitude = altitude;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public Proto2Event toProto2Event(){
        Proto2Event event = new Proto2Event();
        event.setEventID(this.getEventID());
        event.setEventType(this.getEventType());
        event.setOrigin(this.getOrigin());
        event.setLat(this.getLat());
        event.setLon(this.getLon());
        event.setAltitude(this.getAltitude());
        event.setRadius(this.getRadius());
        return event;
    }

    @Override
    public String toString() {
        return "InternalEventData{" +
                "eventID=" + eventID +
                ", eventType='" + eventType + '\'' +
                ", origin='" + origin + '\'' +
                ", lat=" + lat +
                ", lon=" + lon +
                ", altitude=" + altitude +
                ", radius=" + radius +
                '}';
    }
}
