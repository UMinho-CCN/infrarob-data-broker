package pt.uminho.infrarob.common.objects.standard;

public class Location {
    private DetectionZonesToEventPosition detectionZonesToEventPosition;

    public Location() {
    }

    public Location(DetectionZonesToEventPosition detectionZonesToEventPosition) {
        this.detectionZonesToEventPosition = detectionZonesToEventPosition;
    }

    public DetectionZonesToEventPosition getDetectionZonesToEventPosition() {
        return detectionZonesToEventPosition;
    }

    public void setDetectionZonesToEventPosition(DetectionZonesToEventPosition detectionZonesToEventPosition) {
        this.detectionZonesToEventPosition = detectionZonesToEventPosition;
    }

    @Override
    public String toString() {
        return "Location{" +
                "detectionZonesToEventPosition=" + detectionZonesToEventPosition +
                '}';
    }
}
