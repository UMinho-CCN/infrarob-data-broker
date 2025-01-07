package pt.uminho.infrarob.common.objects.standard.denm;

public class PositionConfidenceEllipse {
    private int semiMajorConfidence;
    private int semiMinorConfidence;
    private int semiMajorOrientation;

    public PositionConfidenceEllipse() {
    }

    public PositionConfidenceEllipse(int semiMajorConfidence, int semiMinorConfidence, int semiMajorOrientation) {
        this.semiMajorConfidence = semiMajorConfidence;
        this.semiMinorConfidence = semiMinorConfidence;
        this.semiMajorOrientation = semiMajorOrientation;
    }

    public int getSemiMajorConfidence() {
        return semiMajorConfidence;
    }

    public void setSemiMajorConfidence(int semiMajorConfidence) {
        this.semiMajorConfidence = semiMajorConfidence;
    }

    public int getSemiMinorConfidence() {
        return semiMinorConfidence;
    }

    public void setSemiMinorConfidence(int semiMinorConfidence) {
        this.semiMinorConfidence = semiMinorConfidence;
    }

    public int getSemiMajorOrientation() {
        return semiMajorOrientation;
    }

    public void setSemiMajorOrientation(int semiMajorOrientation) {
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
