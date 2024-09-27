package pt.uminho.infrarob.common.objects.standard.cam;

public class CAMSpeed {
    private int speedValue;
    private int speedConfidence;

    public CAMSpeed(int speedValue, int speedConfidence) {
        this.speedValue = speedValue;
        this.speedConfidence = speedConfidence;
    }

    public CAMSpeed() {
    }

    public int getSpeedValue() {
        return speedValue;
    }

    public void setSpeedValue(int speedValue) {
        this.speedValue = speedValue;
    }

    public int getSpeedConfidence() {
        return speedConfidence;
    }

    public void setSpeedConfidence(int speedConfidence) {
        this.speedConfidence = speedConfidence;
    }

    @Override
    public String toString() {
        return "CAMSpeed{" +
                "speedValue=" + speedValue +
                ", speedConfidence=" + speedConfidence +
                '}';
    }
}
