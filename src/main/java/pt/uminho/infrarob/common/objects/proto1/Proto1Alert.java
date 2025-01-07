package pt.uminho.infrarob.common.objects.proto1;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import pt.uminho.infrarob.common.objects.enums.InfractionType;
import pt.uminho.infrarob.common.objects.internal.InternalEventData;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Proto1Alert {
    private String timestamp;
    private String evenType;
    private int lat;
    private int lon;

    public Proto1Alert() {
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getEvenType() {
        return evenType;
    }

    public void setEvenType(String evenType) {
        this.evenType = evenType;
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
                ", type=" + evenType +
                ", lat=" + lat +
                ", lon=" + lon +
                '}';
    }

    public InternalEventData toInternalEventDatA(){
        InternalEventData eventData = new InternalEventData();
        if(this.getEvenType().equals("Speeding vehicle")){
            eventData.setEventType(InfractionType.SPEED_INFRACTION);
        }else if(this.getEvenType().equals("SSM")){
            eventData.setEventType(InfractionType.SAFEZONE_INFRACION);
        }
        else{
            eventData.setEventType(InfractionType.UNKNOWN);
        }

        eventData.setLat(this.getLat());
        eventData.setLon(this.getLon());
        return eventData;
    }
}
