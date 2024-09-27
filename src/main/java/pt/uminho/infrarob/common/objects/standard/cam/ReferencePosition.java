package pt.uminho.infrarob.common.objects.standard.cam;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ReferencePosition {
    @JsonProperty("Latitude")
    private int latitude;
    @JsonProperty("Longitude")
    private int longitude;
    @JsonProperty("PositionConfidenceEllipse")
    private CAMPositionConfidenceEllipse positionConfidenceEllipse;
    @JsonProperty("Altitude")
    private CAMAltitude altitude;

    public ReferencePosition(int latitude, int longitude, CAMPositionConfidenceEllipse positionConfidenceEllipse, CAMAltitude altitude) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.positionConfidenceEllipse = positionConfidenceEllipse;
        this.altitude = altitude;
    }

    public ReferencePosition() {
    }

    public int getLatitude() {
        return latitude;
    }

    public void setLatitude(int latitude) {
        this.latitude = latitude;
    }

    public int getLongitude() {
        return longitude;
    }

    public void setLongitude(int longitude) {
        this.longitude = longitude;
    }

    public CAMPositionConfidenceEllipse getPositionConfidenceEllipse() {
        return positionConfidenceEllipse;
    }

    public void setPositionConfidenceEllipse(CAMPositionConfidenceEllipse positionConfidenceEllipse) {
        this.positionConfidenceEllipse = positionConfidenceEllipse;
    }

    public CAMAltitude getAltitude() {
        return altitude;
    }

    public void setAltitude(CAMAltitude altitude) {
        this.altitude = altitude;
    }

    @Override
    public String toString() {
        return "ReferencePosition{" +
                "latitude=" + latitude +
                ", longitude=" + longitude +
                ", PositionConfidenceEllipse=" + positionConfidenceEllipse +
                ", Altitude=" + altitude +
                '}';
    }
}
