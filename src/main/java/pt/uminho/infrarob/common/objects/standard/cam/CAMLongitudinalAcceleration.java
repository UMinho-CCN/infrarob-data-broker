package pt.uminho.infrarob.common.objects.standard.cam;

public class CAMLongitudinalAcceleration {
    private int value;
    private int confidence;

    public CAMLongitudinalAcceleration() {
    }

    public CAMLongitudinalAcceleration(int value, int confidence) {
        this.value = value;
        this.confidence = confidence;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getConfidence() {
        return confidence;
    }

    public void setConfidence(int confidence) {
        this.confidence = confidence;
    }

    @Override
    public String toString() {
        return "CAMLongitudinalAcceleration{" +
                "value=" + value +
                ", confidence=" + confidence +
                '}';
    }
}
