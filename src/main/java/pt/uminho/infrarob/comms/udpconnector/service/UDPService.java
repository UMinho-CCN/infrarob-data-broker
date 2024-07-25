package pt.uminho.infrarob.comms.udpconnector.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Service;
import pt.uminho.infrarob.common.objects.internal.InternalObjectData;
import pt.uminho.infrarob.events.events.V2XMessageReceivedEvent;


@Service
public class UDPService {
    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;
    private long ID = 0;
    public void receive(Message message){
        String data = new String((byte[]) message.getPayload());
        String posData[] = data.split(";");
        int lon = Integer.parseInt(posData[2]);///10000000;
        int lat = Integer.parseInt(posData[1]);///10000000;
        int speed = Integer.parseInt(posData[3]);
        int acc = Integer.parseInt(posData[4]);

        //String vehicleID, String vehicleType, int lat, int latConfidence, int lon,
        // int lonConfidence, long lastUpdate, boolean isInside, int speed, int speedConfidence,
        // int acc, int accConvidence, int heading, int headingConfidence, int length, int lengthConfidence,
        // int lane, int laneConfidence, int altitude, int altitudeConfidene) {

        InternalObjectData internalObjectData = new InternalObjectData(
                posData[0],
                "",
                lat,
                0,
                lon,
                0,
                System.currentTimeMillis(),
                false,
                speed,
                0,
                acc,
                0,
                0,
                0,
                0,
                0,
                0,
                0,
                0,
                0,
                0
        );

        V2XMessageReceivedEvent event = new V2XMessageReceivedEvent(this, internalObjectData);
        applicationEventPublisher.publishEvent(event);
    }
}
