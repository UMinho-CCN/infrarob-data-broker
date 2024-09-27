package pt.uminho.infrarob.common.objects.standard.denm;

public class Position {
    private ValueConfidence xCoordinate;
    private ValueConfidence yCoordinate;

    public Position() {
    }

    public Position(ValueConfidence xCoordinate, ValueConfidence yCoordinate) {
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
    }

    public ValueConfidence getxCoordinate() {
        return xCoordinate;
    }

    public void setxCoordinate(ValueConfidence xCoordinate) {
        this.xCoordinate = xCoordinate;
    }

    public ValueConfidence getyCoordinate() {
        return yCoordinate;
    }

    public void setyCoordinate(ValueConfidence yCoordinate) {
        this.yCoordinate = yCoordinate;
    }

    @Override
    public String toString() {
        return "Position{" +
                "xCoordinate=" + xCoordinate +
                ", yCoordinate=" + yCoordinate +
                '}';
    }
}
