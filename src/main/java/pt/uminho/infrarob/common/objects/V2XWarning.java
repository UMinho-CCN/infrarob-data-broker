package pt.uminho.infrarob.common.objects;

import pt.uminho.infrarob.common.objects.internal.InternalObjectData;
import pt.uminho.infrarob.common.objects.ws.ObjectDataWS;

public class V2XWarning {
    private String message;
    private ObjectDataWS objectDataWS;
    private WarningType warningType;

    public V2XWarning(String message, ObjectDataWS objectDataWS, WarningType warningType) {
        this.message = message;
        this.objectDataWS = objectDataWS;
        this.warningType = warningType;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ObjectDataWS getVehiclePosition() {
        return objectDataWS;
    }

    public void setVehiclePosition(ObjectDataWS internalObjectData) {
        this.objectDataWS = internalObjectData;
    }

    public WarningType getWarningType() {
        return warningType;
    }

    public void setWarningType(WarningType warningType) {
        this.warningType = warningType;
    }
}
