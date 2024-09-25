package pt.uminho.infrarob.common.objects.standard;

public class Altitude {
    private String altitudeValue;
    private String altitudeConfidence;

    public Altitude() {
    }

    public Altitude(String altitudeValue, String altitudeConfidence) {
        this.altitudeValue = altitudeValue;
        this.altitudeConfidence = altitudeConfidence;
    }

    public String getAltitudeValue() {
        return altitudeValue;
    }

    public void setAltitudeValue(String altitudeValue) {
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
        return "Altitude{" +
                "altitudeValue='" + altitudeValue + '\'' +
                ", altitudeConfidence='" + altitudeConfidence + '\'' +
                '}';
    }
}
