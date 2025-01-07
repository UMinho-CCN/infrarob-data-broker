package pt.uminho.infrarob.comms.udpconnector.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Service;
import pt.uminho.infrarob.common.objects.enums.InfractionType;
import pt.uminho.infrarob.common.objects.internal.InternalData;
import pt.uminho.infrarob.common.objects.internal.InternalEventData;
import pt.uminho.infrarob.common.objects.internal.InternalObjectData;
import pt.uminho.infrarob.common.objects.proto1.Proto1Alert;
import pt.uminho.infrarob.events.events.V2XMessageReceivedEvent;
import pt.uminho.infrarob.events.events.V2xMessageOutputEvent;


@Service
public class UDPServiceAlerts {
    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;
    private long ID = 0;
    public void receive(Message message){
        String data = new String((byte[]) message.getPayload());
        InternalData internalObjectData = new InternalData();

        /*
        String posData[] = data.split(";");

        InternalEventData eventData = new InternalEventData();
        eventData.setLat(0);
        eventData.setLon(0);
        eventData.setEventID(0);
        eventData.setOrigin("RPAS");
        eventData.setEventType(InfractionType.SAFEZONE_INFRACION);

         */
        ObjectMapper mapper = new ObjectMapper();
        Proto1Alert proto1Alert = null;
        try {
            proto1Alert = mapper.readValue(data, Proto1Alert.class);
            InternalEventData eventData = proto1Alert.toInternalEventDatA();
            eventData.setOrigin("RPAS");
            internalObjectData.addEvents(eventData);
            System.out.println("WARNING RECEIVED: " + data);
            V2xMessageOutputEvent outputEvent = new V2xMessageOutputEvent(this, internalObjectData);

            applicationEventPublisher.publishEvent(outputEvent);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }


    }
}
