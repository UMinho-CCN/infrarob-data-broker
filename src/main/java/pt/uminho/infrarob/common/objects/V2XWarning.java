package pt.uminho.infrarob.common.objects;

public class V2XWarning {
    private String message;
    private VehiclePosition vehiclePosition;
    private WarningType warningType;

    public V2XWarning(String message, VehiclePosition vehiclePosition, WarningType warningType) {
        this.message = message;
        this.vehiclePosition = vehiclePosition;
        this.warningType = warningType;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public VehiclePosition getVehiclePosition() {
        return vehiclePosition;
    }

    public void setVehiclePosition(VehiclePosition vehiclePosition) {
        this.vehiclePosition = vehiclePosition;
    }

    public WarningType getWarningType() {
        return warningType;
    }

    public void setWarningType(WarningType warningType) {
        this.warningType = warningType;
    }
}
