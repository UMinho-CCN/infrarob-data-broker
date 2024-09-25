package pt.uminho.infrarob.common.objects.standard;

public class ActionId {
    private long originatingStationId;
    private long sequenceNumber;

    public ActionId() {
    }

    public ActionId(long originatingStationId, long sequenceNumber) {
        this.originatingStationId = originatingStationId;
        this.sequenceNumber = sequenceNumber;
    }

    public long getOriginatingStationId() {
        return originatingStationId;
    }

    public void setOriginatingStationId(long originatingStationId) {
        this.originatingStationId = originatingStationId;
    }

    public long getSequenceNumber() {
        return sequenceNumber;
    }

    public void setSequenceNumber(long sequenceNumber) {
        this.sequenceNumber = sequenceNumber;
    }

    @Override
    public String toString() {
        return "ActionId{" +
                "originatingStationId=" + originatingStationId +
                ", sequenceNumber=" + sequenceNumber +
                '}';
    }
}
