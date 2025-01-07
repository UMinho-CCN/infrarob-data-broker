package pt.uminho.infrarob.common.objects.standard.denm;

import java.util.ArrayList;
import java.util.List;

public class Location {
    private ArrayList<ArrayList<DetectionZonesToEventPosition>> detectionZonesToEventPosition;

    public Location() {
    }

    public Location(ArrayList<ArrayList<DetectionZonesToEventPosition>> detectionZonesToEventPosition) {
        this.detectionZonesToEventPosition = detectionZonesToEventPosition;
    }

    public ArrayList<ArrayList<DetectionZonesToEventPosition>> getDetectionZonesToEventPosition() {
        return detectionZonesToEventPosition;
    }

    public void setDetectionZonesToEventPosition(ArrayList<ArrayList<DetectionZonesToEventPosition>> detectionZonesToEventPosition) {
        this.detectionZonesToEventPosition = detectionZonesToEventPosition;
    }
}
