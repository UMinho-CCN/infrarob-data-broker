package pt.uminho.infrarob.events.manager;

import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import pt.uminho.infrarob.common.objects.VehiclePosition;
import pt.uminho.infrarob.common.singleton.MqttConnectionShare;
import pt.uminho.infrarob.common.singleton.PolygonCoordinatesSingleton;
import pt.uminho.infrarob.common.singleton.VehicleDataShare;
import pt.uminho.infrarob.events.events.SafeZoneInfractionEvent;
import pt.uminho.infrarob.events.events.V2XMessageReceivedEvent;

import java.nio.charset.StandardCharsets;

@Component
public class V2XEventManager {
    private long ID = 0;

    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    @Async
    @EventListener
    public void handleReceivedV2XMessage(V2XMessageReceivedEvent message){

        boolean isInside = PolygonCoordinatesSingleton.getIntance().isInside(
                Double.parseDouble(message.getVehiclePosition().getLat()),
                Double.parseDouble(message.getVehiclePosition().getLon()));

        VehiclePosition vehiclePosition = VehicleDataShare.getInstance().getVehiclePosition(message.getVehiclePosition().getVehicleID());

        boolean pastInside = vehiclePosition == null ? isInside : vehiclePosition.isInside();

        if(pastInside && !isInside){
            SafeZoneInfractionEvent event = new SafeZoneInfractionEvent(this, vehiclePosition);
            applicationEventPublisher.publishEvent(event);
        }

        if(message.isStoreInCash()){
            VehicleDataShare.getInstance().addVehiclePosition(message.getVehiclePosition());
        }
        if(message.isSendToMQTT()){
            try {
                MqttMessage mqttMessage = new MqttMessage(message.getVehiclePosition().toStringWithID(ID).getBytes(StandardCharsets.UTF_8));
                MqttConnectionShare.getInstance().publishToClient(mqttMessage);
                ID++;
            } catch (MqttException e) {
                throw new RuntimeException(e);
            }
        }

        VehicleDataShare.getInstance().getVehiclePosition(message.getVehiclePosition().getVehicleID()).setInside(isInside);
    }
}
