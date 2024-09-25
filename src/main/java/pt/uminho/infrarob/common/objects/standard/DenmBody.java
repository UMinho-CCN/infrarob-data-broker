package pt.uminho.infrarob.common.objects.standard;

public class DenmBody {
    private DenmManagement management;
    private Situation situation;
    private Location location;
    private Alacarte alacarte;

    public DenmBody() {
    }

    public DenmBody(DenmManagement management, Situation situation, Location location, Alacarte alacarte) {
        this.management = management;
        this.situation = situation;
        this.location = location;
        this.alacarte = alacarte;
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

    public Alacarte getAlacarte() {
        return alacarte;
    }

    public void setAlacarte(Alacarte alacarte) {
        this.alacarte = alacarte;
    }

    @Override
    public String toString() {
        return "DenmBody{" +
                "management=" + management +
                ", situation=" + situation +
                ", location=" + location +
                ", alacarte=" + alacarte +
                '}';
    }
}
