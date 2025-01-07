package pt.uminho.infrarob.common.objects.standard.cam;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CAMAltitude {
    @JsonProperty("altitudeValue")
    private int altitudeValue;


    public CAMAltitude() {
    }

    public CAMAltitude(int altitudeValue, int altitudeConfidence) {
        this.altitudeValue = altitudeValue;
    }

    public int getAltitudeValue() {
        return altitudeValue;
    }

    public void setAltitudeValue(int altitudeValue) {
        this.altitudeValue = altitudeValue;
    }


    @Override
    public String toString() {
        return "CAMAltitude{" +
                "AltitudeValue=" + altitudeValue+
                '}';
    }
}
