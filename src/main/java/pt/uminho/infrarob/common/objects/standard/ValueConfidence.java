package pt.uminho.infrarob.common.objects.standard;

public class ValueConfidence {
    private int value;
    private String confidence;

    public ValueConfidence() {
    }

    public ValueConfidence(int value, String confidence) {
        this.value = value;
        this.confidence = confidence;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getConfidence() {
        return confidence;
    }

    public void setConfidence(String confidence) {
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
