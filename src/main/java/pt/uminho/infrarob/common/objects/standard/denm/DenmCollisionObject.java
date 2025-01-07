package pt.uminho.infrarob.common.objects.standard.denm;

public class DenmCollisionObject {
    private int vehicleSubClass;

    public DenmCollisionObject(int collisionObject) {
        this.vehicleSubClass = collisionObject;
    }

    public DenmCollisionObject() {
    }

    public int getVehicleSubClass() {
        return vehicleSubClass;
    }

    public void setVehicleSubClass(int vehicleSubClass) {
        this.vehicleSubClass = vehicleSubClass;
    }

    @Override
    public String toString() {
        return "DenmCollisionObject{" +
                "collisionObject=" + vehicleSubClass +
                '}';
    }
}
