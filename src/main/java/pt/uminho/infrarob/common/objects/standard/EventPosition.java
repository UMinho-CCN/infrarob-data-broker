package pt.uminho.infrarob.common.objects.standard;

public class EventPosition {
    private long latitude;
    private long longitude;

    private PositionConfidenceEllipse positionConfidenceEllipse;
    private Altitude altitude;

    public EventPosition() {
    }

    public EventPosition(long latitude, long longitude, PositionConfidenceEllipse positionConfidenceEllipse, Altitude altitude) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.positionConfidenceEllipse = positionConfidenceEllipse;
        this.altitude = altitude;
    }

    public long getLatitude() {
        return latitude;
    }

    public void setLatitude(long latitude) {
        this.latitude = latitude;
    }

    public long getLongitude() {
        return longitude;
    }

    public void setLongitude(long longitude) {
        this.longitude = longitude;
    }

    public PositionConfidenceEllipse getPositionConfidenceEllipse() {
        return positionConfidenceEllipse;
    }

    public void setPositionConfidenceEllipse(PositionConfidenceEllipse positionConfidenceEllipse) {
        this.positionConfidenceEllipse = positionConfidenceEllipse;
    }

    public Altitude getAltitude() {
        return altitude;
    }

    public void setAltitude(Altitude altitude) {
        this.altitude = altitude;
    }

    @Override
    public String toString() {
        return "EventPosition{" +
                "latitude=" + latitude +
                ", longitude=" + longitude +
                ", positionConfidenceEllipse=" + positionConfidenceEllipse +
                ", altitude=" + altitude +
                '}';
    }
}
