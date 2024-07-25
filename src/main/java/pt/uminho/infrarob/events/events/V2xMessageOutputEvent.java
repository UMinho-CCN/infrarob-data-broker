package pt.uminho.infrarob.events.events;

import org.springframework.context.ApplicationEvent;
import pt.uminho.infrarob.common.objects.internal.InternalData;

public class V2xMessageOutputEvent extends ApplicationEvent {
    private InternalData data;

    public V2xMessageOutputEvent(Object source, InternalData data) {
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
        return "V2xMessageOutputEvent{" +
                "data=" + data +
                '}';
    }
}
