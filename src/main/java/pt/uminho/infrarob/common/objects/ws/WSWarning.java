package pt.uminho.infrarob.common.objects.ws;

import pt.uminho.infrarob.common.objects.enums.InfractionType;

public class WSWarning {
    private String message;
    private ObjectDataWS objectDataWS;
    private InfractionType warningType;

    public WSWarning(String message, ObjectDataWS objectDataWS, InfractionType warningType) {
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

    public ObjectDataWS getObjectDataWS() {
        return objectDataWS;
    }

    public void setObjectDataWS(ObjectDataWS objectDataWS) {
        this.objectDataWS = objectDataWS;
    }

    public InfractionType getWarningType() {
        return warningType;
    }

    public void setWarningType(InfractionType warningType) {
        this.warningType = warningType;
    }

    @Override
    public String toString() {
        return "WSWarning{" +
                "message='" + message + '\'' +
                ", objectDataWS=" + objectDataWS +
                ", warningType=" + warningType +
                '}';
    }
}
