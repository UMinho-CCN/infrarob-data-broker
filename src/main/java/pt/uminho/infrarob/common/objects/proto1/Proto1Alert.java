package pt.uminho.infrarob.common.objects.proto1;

import pt.uminho.infrarob.common.objects.enums.InfractionType;
import pt.uminho.infrarob.common.objects.internal.InternalEventData;

public class Proto1Alert {
    private long timestamp;
    private InfractionType type;
    private int lat;
    private int lon;

    public Proto1Alert() {
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public InfractionType getType() {
        return type;
    }

    public void setType(InfractionType type) {
        this.type = type;
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

    @Override
    public String toString() {
        return "Proto1Alert{" +
                "timestamp=" + timestamp +
                ", type=" + type +
                ", lat=" + lat +
                ", lon=" + lon +
                '}';
    }

    public InternalEventData toInternalEventDatA(){
        InternalEventData eventData = new InternalEventData();
        eventData.setEventType(this.getType());
        eventData.setLat(this.getLat());
        eventData.setLon(this.getLon());
        return eventData;
    }
}
