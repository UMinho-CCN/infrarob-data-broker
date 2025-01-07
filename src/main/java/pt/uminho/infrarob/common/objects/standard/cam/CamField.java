package pt.uminho.infrarob.common.objects.standard.cam;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;


public class CamField {
    @JsonProperty("generationDeltaTime")
    private long generationDeltaTime;
    @JsonProperty("camParameters")
    private CAMParameters camParameters;

    public CamField() {
    }

    public CamField(long generationDeltaTime, CAMParameters camParameters) {
        this.generationDeltaTime = generationDeltaTime;
        this.camParameters = camParameters;
    }

    public long getGenerationDeltaTime() {
        return generationDeltaTime;
    }

    public void setGenerationDeltaTime(long generationDeltaTime) {
        this.generationDeltaTime = generationDeltaTime;
    }

    public CAMParameters getCamParameters() {
        return camParameters;
    }

    public void setCamParameters(CAMParameters camParameters) {
        this.camParameters = camParameters;
    }

    @Override
    public String toString() {
        return "CamField{" +
                "GenerationDeltaTime=" + generationDeltaTime +
                ", CamParameters=" + camParameters +
                '}';
    }
}
