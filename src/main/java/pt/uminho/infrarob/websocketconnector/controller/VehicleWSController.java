package pt.uminho.infrarob.websocketconnector.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Controller;
import org.springframework.web.socket.messaging.SessionSubscribeEvent;
import pt.uminho.infrarob.common.objects.VehiclePosition;
import pt.uminho.infrarob.common.singleton.PolygonCoordinatesSingleton;
import pt.uminho.infrarob.common.singleton.VehicleDataShare;
import pt.uminho.infrarob.events.events.SafeZoneInfractionEvent;
import pt.uminho.infrarob.websocketconnector.objects.PolygonCoordinates;
import pt.uminho.infrarob.websocketconnector.objects.VehicleResponseData;

import java.util.List;
import java.util.Objects;

@Controller
public class VehicleWSController {
    private final String WARNING_TOPIC = "/topic/safe-zone-infraction";
    @Autowired
    private WebSocketService webSocketService;

    @MessageMapping("/vehicledata")
    @SendTo("/topic/positioning-data")
    public VehicleResponseData getVeiclePositioningData(){
        List<VehiclePosition> positionList = VehicleDataShare.getInstance().getList();
        VehicleResponseData vehicleResponseData = new VehicleResponseData();
        vehicleResponseData.setPositionList(positionList);
        return vehicleResponseData;
    }
    @MessageMapping("/poylgon-coordinates")
    @SendTo("/topic/polygon-created")
    public String setPolygonCoordinates(List<PolygonCoordinates> coordinates){
        PolygonCoordinatesSingleton.getIntance().addCoordinates(coordinates);
        return "done";
    }

}
