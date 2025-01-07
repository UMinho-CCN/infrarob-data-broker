package pt.uminho.infrarob.common.objects.standard.cam;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
@JsonIgnoreProperties(ignoreUnknown = true)
public class CAMParameters {
    @JsonProperty("basicContainer")
    private CAMBasicContainer basicContainer;

    @JsonProperty("highFrequencyContainer")
    private HighFrequencyContainer highFrequencyContainer;

    public CAMParameters() {
    }

    public CAMParameters(CAMBasicContainer basicContainer, HighFrequencyContainer highFrequencyContainer) {
        this.basicContainer = basicContainer;
        this.highFrequencyContainer = highFrequencyContainer;
    }

    public CAMBasicContainer getBasicContainer() {
        return basicContainer;
    }

    public void setBasicContainer(CAMBasicContainer basicContainer) {
        this.basicContainer = basicContainer;
    }

    public HighFrequencyContainer getHighFrequencyContainer() {
        return highFrequencyContainer;
    }

    public void setHighFrequencyContainer(HighFrequencyContainer highFrequencyContainer) {
        this.highFrequencyContainer = highFrequencyContainer;
    }

    @Override
    public String toString() {
        return "CAMParameters{" +
                "basicContainer=" + basicContainer +
                ", highFrequencyContainer=" + highFrequencyContainer +
                '}';
    }
}
