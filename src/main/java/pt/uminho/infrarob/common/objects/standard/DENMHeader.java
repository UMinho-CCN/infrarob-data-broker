package pt.uminho.infrarob.common.objects.standard;

public class DENMHeader {
    private int protocolVersion;
    private String messageId;
    private long stationId;

    public DENMHeader() {
    }

    public DENMHeader(int protocolVersion, String messageId, long stationId) {
        this.protocolVersion = protocolVersion;
        this.messageId = messageId;
        this.stationId = stationId;
    }

    public int getProtocolVersion() {
        return protocolVersion;
    }

    public void setProtocolVersion(int protocolVersion) {
        this.protocolVersion = protocolVersion;
    }

    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    public long getStationId() {
        return stationId;
    }

    public void setStationId(long stationId) {
        this.stationId = stationId;
    }

    @Override
    public String toString() {
        return "DENMHeader{" +
                "protocolVersion=" + protocolVersion +
                ", messageId='" + messageId + '\'' +
                ", stationId=" + stationId +
                '}';
    }
}
