package pt.uminho.infrarob.common.objects.standard.cam;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CAMAltitude {
    @JsonProperty("AltitudeValue")
    private int altitudeValue;
    @JsonProperty("AltitudeConfidence")
    private int altitudeConfidence;

    public CAMAltitude() {
    }

    public CAMAltitude(int altitudeValue, int altitudeConfidence) {
        this.altitudeValue = altitudeValue;
        this.altitudeConfidence = altitudeConfidence;
    }

    public int getAltitudeValue() {
        return altitudeValue;
    }

    public void setAltitudeValue(int altitudeValue) {
        this.altitudeValue = altitudeValue;
    }

    public int getAltitudeConfidence() {
        return altitudeConfidence;
    }

    public void setAltitudeConfidence(int altitudeConfidence) {
        this.altitudeConfidence = altitudeConfidence;
    }

    @Override
    public String toString() {
        return "CAMAltitude{" +
                "AltitudeValue=" + altitudeValue +
                ", AltutudeConfidence=" + altitudeConfidence +
                '}';
    }
}
