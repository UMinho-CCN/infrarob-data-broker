package pt.uminho.infrarob.common.objects.standard.denm;

public class EventType {
    private String ccAndScc;

    public EventType() {
    }

    public EventType(String ccAndScc) {
        this.ccAndScc = ccAndScc;
    }

    public String getCcAndScc() {
        return ccAndScc;
    }

    public void setCcAndScc(String ccAndScc) {
        this.ccAndScc = ccAndScc;
    }

    @Override
    public String toString() {
        return "EventType{" +
                "ccAndScc='" + ccAndScc + '\'' +
                '}';
    }
}
