package pt.uminho.infrarob.common.objects.standard.cam;

import com.fasterxml.jackson.annotation.JsonProperty;

public class HighFrequencyContainer {
    @JsonProperty("selected")
    private int selected;
    private BasicVehicleContainerHighFrequency basicVehicleContainerHighFrequency;

    public HighFrequencyContainer() {
    }

    public HighFrequencyContainer(int selected, BasicVehicleContainerHighFrequency basicVehicleContainerHighFrequency) {
        this.selected = selected;
        this.basicVehicleContainerHighFrequency = basicVehicleContainerHighFrequency;
    }

    public int getSelected() {
        return selected;
    }

    public void setSelected(int selected) {
        this.selected = selected;
    }

    public BasicVehicleContainerHighFrequency getBasicVehicleContainerHighFrequency() {
        return basicVehicleContainerHighFrequency;
    }

    public void setBasicVehicleContainerHighFrequency(BasicVehicleContainerHighFrequency basicVehicleContainerHighFrequency) {
        this.basicVehicleContainerHighFrequency = basicVehicleContainerHighFrequency;
    }

    @Override
    public String toString() {
        return "HighFrequencyContainer{" +
                "selected=" + selected +
                ", basicVehicleContainerHighFrequency=" + basicVehicleContainerHighFrequency +
                '}';
    }
}
