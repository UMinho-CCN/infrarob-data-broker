package pt.uminho.infrarob.common.objects.standard;

import java.util.List;

public class PredictedPaths {
    private List <PredictedPath> pathPredicted;
    private String usageIndication;
    private String confidenceLevel;

    public PredictedPaths() {
    }

    public PredictedPaths(List<PredictedPath> pathPredicted, String usageIndication, String confidenceLevel) {
        this.pathPredicted = pathPredicted;
        this.usageIndication = usageIndication;
        this.confidenceLevel = confidenceLevel;
    }

    public List<PredictedPath> getPathPredicted() {
        return pathPredicted;
    }

    public void setPathPredicted(List<PredictedPath> pathPredicted) {
        this.pathPredicted = pathPredicted;
    }

    public String getUsageIndication() {
        return usageIndication;
    }

    public void setUsageIndication(String usageIndication) {
        this.usageIndication = usageIndication;
    }

    public String getConfidenceLevel() {
        return confidenceLevel;
    }

    public void setConfidenceLevel(String confidenceLevel) {
        this.confidenceLevel = confidenceLevel;
    }

    @Override
    public String toString() {
        return "PredictedPaths{" +
                "pathPredicted=" + pathPredicted +
                ", usageIndication='" + usageIndication + '\'' +
                ", confidenceLevel='" + confidenceLevel + '\'' +
                '}';
    }
}
