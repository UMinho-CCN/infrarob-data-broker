package pt.uminho.infrarob.common.objects.standard.denm;

public class DetectionZonesToEventPosition {
    private PathPosition pathPosition;

    public DetectionZonesToEventPosition() {
    }

    public DetectionZonesToEventPosition(PathPosition pathPosition) {
        this.pathPosition = pathPosition;
    }

    public PathPosition getPathPosition() {
        return pathPosition;
    }

    @Override
    public String toString() {
        return "DetectionZonesToEventPosition{" +
                "pathPosition=" + pathPosition +
                '}';
    }

    public void setPathPosition(PathPosition pathPosition) {
        this.pathPosition = pathPosition;
    }


}
