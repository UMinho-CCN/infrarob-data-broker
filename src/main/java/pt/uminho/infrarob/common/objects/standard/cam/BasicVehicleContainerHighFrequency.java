package pt.uminho.infrarob.common.objects.standard.cam;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BasicVehicleContainerHighFrequency {
    private CAMHeading heading;
    private CAMSpeed speed;
    private CAMLongitudinalAcceleration longitudinalAcceleration;

    public BasicVehicleContainerHighFrequency() {
    }

    public BasicVehicleContainerHighFrequency(CAMHeading heading, CAMSpeed speed, CAMLongitudinalAcceleration longitudinalAcceleration) {
        this.heading = heading;
        this.speed = speed;
        this.longitudinalAcceleration = longitudinalAcceleration;
    }

    public CAMHeading getHeading() {
        return heading;
    }

    public void setHeading(CAMHeading heading) {
        this.heading = heading;
    }

    public CAMSpeed getSpeed() {
        return speed;
    }

    public void setSpeed(CAMSpeed speed) {
        this.speed = speed;
    }

    public CAMLongitudinalAcceleration getLongitudinalAcceleration() {
        return longitudinalAcceleration;
    }

    public void setLongitudinalAcceleration(CAMLongitudinalAcceleration longitudinalAcceleration) {
        this.longitudinalAcceleration = longitudinalAcceleration;
    }

    @Override
    public String toString() {
        return "BasicVehicleContainerHighFrequency{" +
                "heading=" + heading +
                ", speed=" + speed +
                ", longitudinalAcceleration=" + longitudinalAcceleration +
                '}';
    }
}
