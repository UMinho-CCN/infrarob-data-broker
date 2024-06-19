package pt.uminho.infrarob.events.events;

import org.springframework.context.ApplicationEvent;
import pt.uminho.infrarob.common.objects.VehiclePosition;

public class V2XMessageReceivedEvent extends ApplicationEvent {
    private VehiclePosition vehiclePosition;
    private boolean storeInCash;
    private boolean sendToMQTT;

    public V2XMessageReceivedEvent(Object source, VehiclePosition vehiclePosition, boolean storeInCash, boolean sendToMQTT) {
        super(source);
        this.vehiclePosition = vehiclePosition;
        this.storeInCash = storeInCash;
        this.sendToMQTT = sendToMQTT;
    }

    public VehiclePosition getVehiclePosition() {
        return vehiclePosition;
    }

    public void setVehiclePosition(VehiclePosition vehiclePosition) {
        this.vehiclePosition = vehiclePosition;
    }

    public boolean isStoreInCash() {
        return storeInCash;
    }

    public void setStoreInCash(boolean storeInCash) {
        this.storeInCash = storeInCash;
    }

    public boolean isSendToMQTT() {
        return sendToMQTT;
    }

    public void setSendToMQTT(boolean sendToMQTT) {
        this.sendToMQTT = sendToMQTT;
    }
}
