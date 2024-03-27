package pt.uminho.infrarob.websocketconnector.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import pt.uminho.infrarob.common.objects.VehiclePosition;
import pt.uminho.infrarob.common.singleton.VehicleDataShare;
import pt.uminho.infrarob.websocketconnector.objects.VehicleResponseData;

import java.util.List;

@Controller
public class VehicleWSController {
    @MessageMapping("/vehicledata")
    @SendTo("/topic/positioning-data")
    public VehicleResponseData getVeiclePositioningData(){
        List<VehiclePosition> positionList = VehicleDataShare.getInstance().getList();
        VehicleResponseData vehicleResponseData = new VehicleResponseData();
        vehicleResponseData.setPositionList(positionList);
        System.out.println("position list: " + positionList);
        return vehicleResponseData;
    }
}
