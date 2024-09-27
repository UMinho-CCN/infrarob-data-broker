package pt.uminho.infrarob.common.objects.standard.denm;

public class PositionConfidenceEllipse {
    private String semiMajorConfidence;
    private String semiMinorConfidence;
    private String semiMajorOrientation;

    public PositionConfidenceEllipse() {
    }

    public PositionConfidenceEllipse(String semiMajorConfidence, String semiMinorConfidence, String semiMajorOrientation) {
        this.semiMajorConfidence = semiMajorConfidence;
        this.semiMinorConfidence = semiMinorConfidence;
        this.semiMajorOrientation = semiMajorOrientation;
    }

    public String getSemiMajorConfidence() {
        return semiMajorConfidence;
    }

    public void setSemiMajorConfidence(String semiMajorConfidence) {
        this.semiMajorConfidence = semiMajorConfidence;
    }

    public String getSemiMinorConfidence() {
        return semiMinorConfidence;
    }

    public void setSemiMinorConfidence(String semiMinorConfidence) {
        this.semiMinorConfidence = semiMinorConfidence;
    }

    public String getSemiMajorOrientation() {
        return semiMajorOrientation;
    }

    public void setSemiMajorOrientation(String semiMajorOrientation) {
        this.semiMajorOrientation = semiMajorOrientation;
    }

    @Override
    public String toString() {
        return "CAMPositionConfidenceEllipse{" +
                "semiMajorConfidence='" + semiMajorConfidence + '\'' +
                ", semiMinorConfidence='" + semiMinorConfidence + '\'' +
                ", semiMajorOrientation='" + semiMajorOrientation + '\'' +
                '}';
    }
}
