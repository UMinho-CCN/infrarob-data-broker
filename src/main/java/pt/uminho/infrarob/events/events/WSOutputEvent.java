package pt.uminho.infrarob.events.events;

import org.springframework.context.ApplicationEvent;
import pt.uminho.infrarob.common.objects.internal.InternalData;

public class WSOutputEvent extends ApplicationEvent {
    private InternalData data;

    public WSOutputEvent(Object source, InternalData data) {
        super(source);
        this.data = data;
    }

    public InternalData getData() {
        return data;
    }

    public void setData(InternalData data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "WSOutputEvent{" +
                "data=" + data +
                '}';
    }
}
