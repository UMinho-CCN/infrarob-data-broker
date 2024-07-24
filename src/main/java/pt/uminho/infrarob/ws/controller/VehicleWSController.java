package pt.uminho.infrarob.ws.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import pt.uminho.infrarob.common.objects.internal.InternalObjectData;
import pt.uminho.infrarob.common.singleton.VehicleDataShare;
import pt.uminho.infrarob.common.objects.ws.VehicleResponseDataWS;

import java.util.List;

@Controller
public class VehicleWSController {

    @MessageMapping("/vehicledata")
    @SendTo("/topic/positioning-data")
    public VehicleResponseDataWS getVeiclePositioningData(){

        List<InternalObjectData> positionList = VehicleDataShare.getInstance().getList();
        VehicleResponseDataWS vehicleResponseData = new VehicleResponseDataWS();
        for (int i = 0; i < positionList.size(); i++) {
            InternalObjectData internalObjectData = positionList.get(i);
            vehicleResponseData.addPosition(internalObjectData.toObjectDataWS());
        }
        return vehicleResponseData;
    }


}
