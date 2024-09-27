package pt.uminho.infrarob.common.objects.standard.denm;

import java.util.List;

public class PreCrash {
    private PerceivedPreCrashObject perceivedPreCrashObject;
    private int timeToCollision;
    private PredictedPaths predictedPaths;

    public PreCrash() {
    }

    public PreCrash(PerceivedPreCrashObject perceivedPreCrashObject, int timeToCollision, PredictedPaths predictedPaths) {
        this.perceivedPreCrashObject = perceivedPreCrashObject;
        this.timeToCollision = timeToCollision;
        this.predictedPaths = predictedPaths;
    }

    public PerceivedPreCrashObject getPerceivedPreCrashObject() {
        return perceivedPreCrashObject;
    }

    public void setPerceivedPreCrashObject(PerceivedPreCrashObject perceivedPreCrashObject) {
        this.perceivedPreCrashObject = perceivedPreCrashObject;
    }

    public int getTimeToCollision() {
        return timeToCollision;
    }

    public void setTimeToCollision(int timeToCollision) {
        this.timeToCollision = timeToCollision;
    }

    public PredictedPaths getPredictedPaths() {
        return predictedPaths;
    }

    public void setPredictedPaths(PredictedPaths predictedPaths) {
        this.predictedPaths = predictedPaths;
    }

    @Override
    public String toString() {
        return "PreCrash{" +
                "perceivedPreCrashObject=" + perceivedPreCrashObject +
                ", timeToCollision=" + timeToCollision +
                ", predictedPaths=" + predictedPaths +
                '}';
    }
}
