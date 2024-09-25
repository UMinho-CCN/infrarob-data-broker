package pt.uminho.infrarob.common.objects.standard;

public class PathPosition {
    private String deltaLatitude;
    private String deltaLongitude;
    private String deltaAltitude;

    public PathPosition() {
    }

    public PathPosition(String deltaLatitude, String deltaLongitude, String deltaAltitude) {
        this.deltaLatitude = deltaLatitude;
        this.deltaLongitude = deltaLongitude;
        this.deltaAltitude = deltaAltitude;
    }

    public String getDeltaLatitude() {
        return deltaLatitude;
    }

    public void setDeltaLatitude(String deltaLatitude) {
        this.deltaLatitude = deltaLatitude;
    }

    public String getDeltaLongitude() {
        return deltaLongitude;
    }

    public void setDeltaLongitude(String deltaLongitude) {
        this.deltaLongitude = deltaLongitude;
    }

    public String getDeltaAltitude() {
        return deltaAltitude;
    }

    public void setDeltaAltitude(String deltaAltitude) {
        this.deltaAltitude = deltaAltitude;
    }

    @Override
    public String toString() {
        return "PathPosition{" +
                "deltaLatitude='" + deltaLatitude + '\'' +
                ", deltaLongitude='" + deltaLongitude + '\'' +
                ", deltaAltitude='" + deltaAltitude + '\'' +
                '}';
    }
}
