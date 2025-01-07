package pt.uminho.infrarob.common.objects.standard.denm;

public class EventType {
    private DenmCCAndSCC ccAndScc;

    public EventType() {
    }

    public EventType(DenmCCAndSCC ccAndScc) {
        this.ccAndScc = ccAndScc;
    }

    public DenmCCAndSCC getCcAndScc() {
        return ccAndScc;
    }

    public void setCcAndScc(DenmCCAndSCC ccAndScc) {
        this.ccAndScc = ccAndScc;
    }

    @Override
    public String toString() {
        return "EventType{" +
                "ccAndScc='" + ccAndScc + '\'' +
                '}';
    }
}
