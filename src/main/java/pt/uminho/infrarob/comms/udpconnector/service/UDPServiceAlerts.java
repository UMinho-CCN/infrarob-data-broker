package pt.uminho.infrarob.comms.udpconnector.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Service;
import pt.uminho.infrarob.common.objects.enums.InfractionType;
import pt.uminho.infrarob.common.objects.internal.InternalData;
import pt.uminho.infrarob.common.objects.internal.InternalEventData;
import pt.uminho.infrarob.common.objects.internal.InternalObjectData;
import pt.uminho.infrarob.events.events.V2XMessageReceivedEvent;
import pt.uminho.infrarob.events.events.V2xMessageOutputEvent;


@Service
public class UDPServiceAlerts {
    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;
    private long ID = 0;
    public void receive(Message message){
        String data = new String((byte[]) message.getPayload());
        String posData[] = data.split(";");
        InternalData internalObjectData = new InternalData();
        InternalEventData eventData = new InternalEventData();
        eventData.setLat(0);
        eventData.setLon(0);
        eventData.setEventID(0);
        eventData.setOrigin("RPAS");
        eventData.setEventType(InfractionType.SAFEZONE_INFRACION);
        internalObjectData.addEvents(eventData);

        V2xMessageOutputEvent outputEvent = new V2xMessageOutputEvent(this, internalObjectData);

        applicationEventPublisher.publishEvent(outputEvent);
    }
}
