package pt.uminho.infrarob.common.objects.standard.denm;

public class Alacarte {
    private String collisionObject;
    private PreCrash preCrash;

    public Alacarte() {
    }

    public Alacarte(String collisionObject, PreCrash preCrash) {
        this.collisionObject = collisionObject;
        this.preCrash = preCrash;
    }

    public String getCollisionObject() {
        return collisionObject;
    }

    public void setCollisionObject(String collisionObject) {
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
