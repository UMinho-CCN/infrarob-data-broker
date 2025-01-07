package pt.uminho.infrarob.common.objects.standard.denm;

public class ValueConfidence {
    private int value;
    private int confidence;

    public ValueConfidence() {
    }

    public ValueConfidence(int value, int confidence) {
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
        return "ValueConfidence{" +
                "value=" + value +
                ", confidence='" + confidence + '\'' +
                '}';
    }
}
