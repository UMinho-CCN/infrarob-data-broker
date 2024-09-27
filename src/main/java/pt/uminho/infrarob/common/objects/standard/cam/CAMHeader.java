package pt.uminho.infrarob.common.objects.standard.cam;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CAMHeader {

    @JsonProperty("ProtocolVersion")
    private long protocolVersion;
    @JsonProperty("MessageId")
    private long messageId;
    @JsonProperty("StationId")
    private long stationId;

    public CAMHeader() {
    }

    public CAMHeader(long protocolVersion, long messageId, long stationId) {
        this.protocolVersion = protocolVersion;
        this.messageId = messageId;
        this.stationId = stationId;
    }

    public long getProtocolVersion() {
        return protocolVersion;
    }

    public void setProtocolVersion(long protocolVersion) {
        this.protocolVersion = protocolVersion;
    }

    public long getMessageId() {
        return messageId;
    }

    public void setMessageId(long messageId) {
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
        return "CAMHeader{" +
                "ProtocolVesion=" + protocolVersion +
                ", MessageId=" + messageId +
                ", StationId=" + stationId +
                '}';
    }
}
