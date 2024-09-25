package pt.uminho.infrarob.common.objects.standard;

public class CartesianVelocity {
    private ValueConfidence xVelocity;
    private ValueConfidence yVelocity;

    public CartesianVelocity() {
    }

    public CartesianVelocity(ValueConfidence xVelocity, ValueConfidence yVelocity) {
        this.xVelocity = xVelocity;
        this.yVelocity = yVelocity;
    }

    public ValueConfidence getxVelocity() {
        return xVelocity;
    }

    public void setxVelocity(ValueConfidence xVelocity) {
        this.xVelocity = xVelocity;
    }

    public ValueConfidence getyVelocity() {
        return yVelocity;
    }

    public void setyVelocity(ValueConfidence yVelocity) {
        this.yVelocity = yVelocity;
    }

    @Override
    public String toString() {
        return "CartesianVelocity{" +
                "xVelocity=" + xVelocity +
                ", yVelocity=" + yVelocity +
                '}';
    }
}
