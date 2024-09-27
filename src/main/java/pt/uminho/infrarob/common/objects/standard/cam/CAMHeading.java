package pt.uminho.infrarob.common.objects.standard.cam;

public class CAMHeading {
    private int headingValue;
    private int headingConfidence;

    public CAMHeading() {
    }

    public CAMHeading(int headingValue, int headingConfidence) {
        this.headingValue = headingValue;
        this.headingConfidence = headingConfidence;
    }

    public int getHeadingValue() {
        return headingValue;
    }

    public void setHeadingValue(int headingValue) {
        this.headingValue = headingValue;
    }

    public int getHeadingConfidence() {
        return headingConfidence;
    }

    public void setHeadingConfidence(int headingConfidence) {
        this.headingConfidence = headingConfidence;
    }

    @Override
    public String toString() {
        return "CAMHeading{" +
                "headingValue=" + headingValue +
                ", headingConfidence=" + headingConfidence +
                '}';
    }
}
