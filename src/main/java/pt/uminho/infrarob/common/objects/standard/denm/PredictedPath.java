package pt.uminho.infrarob.common.objects.standard.denm;

public class PredictedPath {
    private int deltaLatitude;
    private int deltaLongitude;
    private String deltaAltitude;
    private String altitudeConfidence;

    public PredictedPath() {
    }

    public PredictedPath(int deltaLatitude, int deltaLongitude, String deltaAltitude, String altitudeConfidence) {
        this.deltaLatitude = deltaLatitude;
        this.deltaLongitude = deltaLongitude;
        this.deltaAltitude = deltaAltitude;
        this.altitudeConfidence = altitudeConfidence;
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

    public String getDeltaAltitude() {
        return deltaAltitude;
    }

    public void setDeltaAltitude(String deltaAltitude) {
        this.deltaAltitude = deltaAltitude;
    }

    public String getAltitudeConfidence() {
        return altitudeConfidence;
    }

    public void setAltitudeConfidence(String altitudeConfidence) {
        this.altitudeConfidence = altitudeConfidence;
    }

    @Override
    public String toString() {
        return "PredictedPath{" +
                "deltaLatitude=" + deltaLatitude +
                ", deltaLongitude=" + deltaLongitude +
                ", deltaAltitude='" + deltaAltitude + '\'' +
                ", altitudeConfidence='" + altitudeConfidence + '\'' +
                '}';
    }
}
