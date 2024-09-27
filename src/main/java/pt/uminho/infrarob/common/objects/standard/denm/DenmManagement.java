package pt.uminho.infrarob.common.objects.standard.denm;

public class DenmManagement {
    private ActionId actionId;
    private long detectionTime;
    private long referenceTime;
    private EventPosition eventPosition;
    private long validityDuration;
    private String stationType;

    public DenmManagement() {
    }

    public DenmManagement(ActionId actionId, long detectionTime, long referenceTime, EventPosition eventPosition, long validityDuration, String stationType) {
        this.actionId = actionId;
        this.detectionTime = detectionTime;
        this.referenceTime = referenceTime;
        this.eventPosition = eventPosition;
        this.validityDuration = validityDuration;
        this.stationType = stationType;
    }

    public ActionId getActionId() {
        return actionId;
    }

    public void setActionId(ActionId actionId) {
        this.actionId = actionId;
    }

    public long getDetectionTime() {
        return detectionTime;
    }

    public void setDetectionTime(long detectionTime) {
        this.detectionTime = detectionTime;
    }

    public long getReferenceTime() {
        return referenceTime;
    }

    public void setReferenceTime(long referenceTime) {
        this.referenceTime = referenceTime;
    }

    public EventPosition getEventPosition() {
        return eventPosition;
    }

    public void setEventPosition(EventPosition eventPosition) {
        this.eventPosition = eventPosition;
    }

    public long getValidityDuration() {
        return validityDuration;
    }

    public void setValidityDuration(long validityDuration) {
        this.validityDuration = validityDuration;
    }

    public String getStationType() {
        return stationType;
    }

    public void setStationType(String stationType) {
        this.stationType = stationType;
    }

    @Override
    public String toString() {
        return "DenmManagement{" +
                "actionId=" + actionId +
                ", detectionTime=" + detectionTime +
                ", referenceTime=" + referenceTime +
                ", eventPosition=" + eventPosition +
                ", validityDuration=" + validityDuration +
                ", stationType='" + stationType + '\'' +
                '}';
    }
}
