package pt.uminho.infrarob.common.objects.standard.denm;

public class Alacarte {
    private DenmCollisionObject collisionObject;
    private PreCrash preCrash;

    public Alacarte() {
    }

    public Alacarte(DenmCollisionObject collisionObject, PreCrash preCrash) {
        this.collisionObject = collisionObject;
        this.preCrash = preCrash;
    }

    public DenmCollisionObject getCollisionObject() {
        return collisionObject;
    }

    public void setCollisionObject(DenmCollisionObject collisionObject) {
        this.collisionObject = collisionObject;
    }

    public PreCrash getPreCrash() {
        return preCrash;
    }

    public void setPreCrash(PreCrash preCrash) {
        this.preCrash = preCrash;
    }

    @Override
    public String toString() {
        return "Alacarte{" +
                "collisionObject='" + collisionObject + '\'' +
                ", preCrash=" + preCrash +
                '}';
    }
}
