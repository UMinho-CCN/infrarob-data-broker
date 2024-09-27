package pt.uminho.infrarob.common.objects.standard.cam;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CAMBasicContainer {
    @JsonProperty("StationType")
    private long stationType;
    @JsonProperty("ReferencePosition")
    private ReferencePosition referencePosition;

    public CAMBasicContainer() {
    }

    public CAMBasicContainer(long stationType, pt.uminho.infrarob.common.objects.standard.cam.ReferencePosition referencePosition) {
        this.stationType = stationType;
        this.referencePosition = referencePosition;
    }

    public long getStationType() {
        return stationType;
    }

    public void setStationType(long stationType) {
        this.stationType = stationType;
    }

    public pt.uminho.infrarob.common.objects.standard.cam.ReferencePosition getReferencePosition() {
        return referencePosition;
    }

    public void setReferencePosition(pt.uminho.infrarob.common.objects.standard.cam.ReferencePosition referencePosition) {
        this.referencePosition = referencePosition;
    }

    @Override
    public String toString() {
        return "CAMBasicContainer{" +
                "StationType=" + stationType +
                ", ReferencePosition=" + referencePosition +
                '}';
    }
}
