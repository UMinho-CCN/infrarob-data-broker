package pt.uminho.infrarob.common.objects.standard.denm;

public class PredictedPath {
    private int deltaLatitude;
    private int deltaLongitude;
    private int deltaAltitude;
    private int altitudeConfidence;

    public PredictedPath() {
    }

    public PredictedPath(int deltaLatitude, int deltaLongitude, int deltaAltitude, int altitudeConfidence) {
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

    public int getDeltaAltitude() {
        return deltaAltitude;
    }

    public void setDeltaAltitude(int deltaAltitude) {
        this.deltaAltitude = deltaAltitude;
    }

    public int getAltitudeConfidence() {
        return altitudeConfidence;
    }

    public void setAltitudeConfidence(int altitudeConfidence) {
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
