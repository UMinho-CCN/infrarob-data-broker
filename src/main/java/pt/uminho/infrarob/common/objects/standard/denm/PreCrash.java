package pt.uminho.infrarob.common.objects.standard.denm;

import java.util.List;

public class PreCrash {
    private PerceivedPreCrashObject perceivedPreCrashObject;
    private int timeToCollision;


    public PreCrash() {
    }

    public PreCrash(PerceivedPreCrashObject perceivedPreCrashObject, int timeToCollision) {
        this.perceivedPreCrashObject = perceivedPreCrashObject;
        this.timeToCollision = timeToCollision;

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



    @Override
    public String toString() {
        return "PreCrash{" +
                "perceivedPreCrashObject=" + perceivedPreCrashObject +
                ", timeToCollision=" + timeToCollision +
                '}';
    }
}
