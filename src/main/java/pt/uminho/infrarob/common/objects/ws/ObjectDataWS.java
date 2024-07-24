package pt.uminho.infrarob.common.objects.ws;

public class ObjectDataWS {
    private String objectID;
    private double lat;
    private double lon;
    private double velocity;

    public ObjectDataWS(String objectID, double lat, double lon, double velocity) {
        this.objectID = objectID;
        this.lat = lat;
        this.lon = lon;
        this.velocity = velocity;
    }

    public ObjectDataWS() {
    }

    public String getObjectID() {
        return objectID;
    }

    public void setObjectID(String objectID) {
        this.objectID = objectID;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    public double getVelocity() {
        return velocity;
    }

    public void setVelocity(double velocity) {
        this.velocity = velocity;
    }

    @Override
    public String toString() {
        return "ObjectDataWS{" +
                "objectID='" + objectID + '\'' +
                ", lat=" + lat +
                ", lon=" + lon +
                ", velocity=" + velocity +
                '}';
    }
}
