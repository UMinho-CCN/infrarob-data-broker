package pt.uminho.infrarob.events.events;

import org.springframework.context.ApplicationEvent;
import pt.uminho.infrarob.common.objects.VehiclePosition;

public class SafeZoneInfractionEvent extends ApplicationEvent {
    private VehiclePosition vehiclePosition;

    public SafeZoneInfractionEvent(Object source, VehiclePosition vehiclePosition) {
        super(source);
        this.vehiclePosition = vehiclePosition;
    }

    public VehiclePosition getVehiclePosition() {
        return vehiclePosition;
    }

    public void setVehiclePosition(VehiclePosition vehiclePosition) {
        this.vehiclePosition = vehiclePosition;
    }
}
