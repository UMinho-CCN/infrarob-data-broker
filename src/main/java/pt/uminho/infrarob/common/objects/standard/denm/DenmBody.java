package pt.uminho.infrarob.common.objects.standard.denm;

public class DenmBody {
    private DenmManagement management;
    private Situation situation;
    private Location location;

    public DenmBody() {
    }

    public DenmBody(DenmManagement management, Situation situation, Location location) {
        this.management = management;
        this.situation = situation;
        this.location = location;
    }

    public DenmManagement getManagement() {
        return management;
    }

    public void setManagement(DenmManagement management) {
        this.management = management;
    }

    public Situation getSituation() {
        return situation;
    }

    public void setSituation(Situation situation) {
        this.situation = situation;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }


    @Override
    public String toString() {
        return "DenmBody{" +
                "management=" + management +
                ", situation=" + situation +
                ", location=" + location +
                '}';
    }
}
