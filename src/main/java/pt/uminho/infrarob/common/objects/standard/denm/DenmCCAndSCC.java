package pt.uminho.infrarob.common.objects.standard.denm;

public class DenmCCAndSCC {
    private int collisionRisk97;

    public DenmCCAndSCC(int collisionRisk97) {
        this.collisionRisk97 = collisionRisk97;
    }

    public DenmCCAndSCC() {
    }

    public int getCollisionRisk97() {
        return collisionRisk97;
    }

    public void setCollisionRisk97(int collisionRisk97) {
        this.collisionRisk97 = collisionRisk97;
    }

    @Override
    public String toString() {
        return "DenmCCAndSCC{" +
                "collisionRisk97='" + collisionRisk97 + '\'' +
                '}';
    }
}
