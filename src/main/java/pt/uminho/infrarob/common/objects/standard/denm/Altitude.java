package pt.uminho.infrarob.common.objects.standard.denm;

public class Altitude {
    private int altitudeValue;
    private String altitudeConfidence;

    public Altitude() {
    }

    public Altitude(int altitudeValue, String altitudeConfidence) {
        this.altitudeValue = altitudeValue;
        this.altitudeConfidence = altitudeConfidence;
    }

    public int getAltitudeValue() {
        return altitudeValue;
    }

    public void setAltitudeValue(int altitudeValue) {
        this.altitudeValue = altitudeValue;
    }

    public String getAltitudeConfidence() {
        return altitudeConfidence;
    }

    public void setAltitudeConfidence(String altitudeConfidence) {
        this.altitudeConfidence = altitudeConfidence;
    }

    @Override
    public String toString() {
        return "CAMAltitude{" +
                "altitudeValue='" + altitudeValue + '\'' +
                ", altitudeConfidence='" + altitudeConfidence + '\'' +
                '}';
    }
}
