package pt.uminho.infrarob.common.objects.standard;

public class Situation {
    private int informationQuality;
    private EventType eventType;

    public Situation() {
    }

    public Situation(int informationQuality, EventType eventType) {
        this.informationQuality = informationQuality;
        this.eventType = eventType;
    }

    public int getInformationQuality() {
        return informationQuality;
    }

    public void setInformationQuality(int informationQuality) {
        this.informationQuality = informationQuality;
    }

    public EventType getEventType() {
        return eventType;
    }

    public void setEventType(EventType eventType) {
        this.eventType = eventType;
    }

    @Override
    public String toString() {
        return "Situation{" +
                "informationQuality=" + informationQuality +
                ", eventType=" + eventType +
                '}';
    }
}
