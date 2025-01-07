
package pt.uminho.infrarob.common.objects.standard.cam;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import pt.uminho.infrarob.common.objects.internal.InternalObjectData;


public class CAMBody {
    @JsonProperty("header")
    private CAMHeader header;
    @JsonProperty("cam")
    private CamField camField;

    public CAMBody() {
    }

    public CAMBody(CAMHeader header, CamField camField) {
        this.header = header;
        this.camField = camField;
    }

    public CAMHeader getHeader() {
        return header;
    }

    public void setHeader(CAMHeader header) {
        this.header = header;
    }

    public CamField getCamField() {
        return camField;
    }

    public void setCamField(CamField camField) {
        this.camField = camField;
    }

    public InternalObjectData toInternalObjectData(){
        InternalObjectData internalObjectData = new InternalObjectData();
        internalObjectData.setVehicleID(this.getHeader().getStationId()+"");
        internalObjectData.setSpeed(this.getCamField().getCamParameters().getHighFrequencyContainer().getBasicVehicleContainerHighFrequency().getSpeed().getSpeedValue()/100);
        internalObjectData.setSpeedConfidence(this.getCamField().getCamParameters().getHighFrequencyContainer().getBasicVehicleContainerHighFrequency().getSpeed().getSpeedConfidence());
        internalObjectData.setAccConvidence(this.getCamField().getCamParameters().getHighFrequencyContainer().getBasicVehicleContainerHighFrequency().getLongitudinalAcceleration().getConfidence());
        internalObjectData.setAcc(this.getCamField().getCamParameters().getHighFrequencyContainer().getBasicVehicleContainerHighFrequency().getLongitudinalAcceleration().getValue());
        internalObjectData.setHeading(this.getCamField().getCamParameters().getHighFrequencyContainer().getBasicVehicleContainerHighFrequency().getHeading().getHeadingValue());
        internalObjectData.setHeadingConfidence(this.getCamField().getCamParameters().getHighFrequencyContainer().getBasicVehicleContainerHighFrequency().getHeading().getHeadingConfidence());
        internalObjectData.setLat(this.getCamField().getCamParameters().getBasicContainer().getReferencePosition().getLatitude());
        internalObjectData.setLatConfidence(0);
        internalObjectData.setLon(this.getCamField().getCamParameters().getBasicContainer().getReferencePosition().getLongitude());
        internalObjectData.setLonConfidence(0);
        internalObjectData.setLength(0);
        internalObjectData.setLengthConfidence(0);
        internalObjectData.setLane(0);
        internalObjectData.setLatConfidence(0);
        internalObjectData.setAltitude(0);
        internalObjectData.setAltitudeConfidene(0);
        internalObjectData.setLength(0);
        internalObjectData.setLengthConfidence(0);
        return internalObjectData;
    }

    @Override
    public String toString() {
        return "CAMBody{" +
                "Header=" + this.header +
                ", CamField=" + this.camField +
                '}';
    }
}
