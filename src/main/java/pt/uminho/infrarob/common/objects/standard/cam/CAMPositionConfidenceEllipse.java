package pt.uminho.infrarob.common.objects.standard.cam;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CAMPositionConfidenceEllipse {
    @JsonProperty("SemiMajorAxisLength")
    private int semiMajorAxisLength;
    @JsonProperty("SemiMinorAxisLength")
    private int semiMinorAxisLength;
    @JsonProperty("SemiMajorAxisOrientation")
    private int semirMajorAxisOrientation;

    public CAMPositionConfidenceEllipse() {
    }

    public CAMPositionConfidenceEllipse(int semiMajorAxisLength, int semiMinorAxisLength, int semirMajorAxisOrientation) {
        this.semiMajorAxisLength = semiMajorAxisLength;
        this.semiMinorAxisLength = semiMinorAxisLength;
        this.semirMajorAxisOrientation = semirMajorAxisOrientation;
    }

    public int getSemiMajorAxisLength() {
        return semiMajorAxisLength;
    }

    public void setSemiMajorAxisLength(int semiMajorAxisLength) {
        this.semiMajorAxisLength = semiMajorAxisLength;
    }

    public int getSemiMinorAxisLength() {
        return semiMinorAxisLength;
    }

    public void setSemiMinorAxisLength(int semiMinorAxisLength) {
        this.semiMinorAxisLength = semiMinorAxisLength;
    }

    public int getSemirMajorAxisOrientation() {
        return semirMajorAxisOrientation;
    }

    public void setSemirMajorAxisOrientation(int semirMajorAxisOrientation) {
        this.semirMajorAxisOrientation = semirMajorAxisOrientation;
    }

    @Override
    public String toString() {
        return "CAMPositionConfidenceEllipse{" +
                "SemiMajorAxisLength=" + semiMajorAxisLength +
                ", SemiMinorAxisLength=" + semiMinorAxisLength +
                ", SemirMajorAxisOrientation=" + semirMajorAxisOrientation +
                '}';
    }
}
