package pt.uminho.infrarob.common.objects.standard.denm;

public class PathPosition {
    private int deltaLatitude;
    private int deltaLongitude;
    private int deltaAltitude;

    public PathPosition() {
    }

    public PathPosition(int deltaLatitude, int deltaLongitude, int deltaAltitude) {
        this.deltaLatitude = deltaLatitude;
        this.deltaLongitude = deltaLongitude;
        this.deltaAltitude = deltaAltitude;
    }

    public int getDeltaLatitude() {
        return deltaLatitude;
    }

    public void setDeltaLatitude(int deltaLatitude) {
        this.deltaLatitude = deltaLatitude;
    }

    public int getDeltaLongitude() {
        return deltaLongitude;
    }

    public void setDeltaLongitude(int deltaLongitude) {
        this.deltaLongitude = deltaLongitude;
    }

    public int getDeltaAltitude() {
        return deltaAltitude;
    }

    public void setDeltaAltitude(int deltaAltitude) {
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
