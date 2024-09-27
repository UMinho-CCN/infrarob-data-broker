package pt.uminho.infrarob.common.objects.standard.denm;

public class PerceivedPreCrashObject {
    private long measurementDeltaTime;
    private Position position;
    private CartesianVelocity velocity;

    public PerceivedPreCrashObject() {
    }

    public PerceivedPreCrashObject(long measurementDeltaTime, Position position, CartesianVelocity velocity) {
        this.measurementDeltaTime = measurementDeltaTime;
        this.position = position;
        this.velocity = velocity;
    }

    public long getMeasurementDeltaTime() {
        return measurementDeltaTime;
    }

    public void setMeasurementDeltaTime(long measurementDeltaTime) {
        this.measurementDeltaTime = measurementDeltaTime;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public CartesianVelocity getVelocity() {
        return velocity;
    }

    public void setVelocity(CartesianVelocity velocity) {
        this.velocity = velocity;
    }

    @Override
    public String toString() {
        return "PerceivedPreCrashObject{" +
                "measurementDeltaTime=" + measurementDeltaTime +
                ", position=" + position +
                ", velocity=" + velocity +
                '}';
    }
}
