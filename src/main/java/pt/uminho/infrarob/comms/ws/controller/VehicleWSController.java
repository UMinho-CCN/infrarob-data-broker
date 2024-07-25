package pt.uminho.infrarob.comms.ws.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import pt.uminho.infrarob.common.objects.internal.InternalObjectData;
import pt.uminho.infrarob.common.singleton.VehicleDataShare;
import pt.uminho.infrarob.common.objects.ws.ObjectsDataWS;

import java.util.List;

@Controller
public class VehicleWSController {

    @MessageMapping("/vehicledata")
    @SendTo("/topic/positioning-data")
    public ObjectsDataWS getVeiclePositioningData(){

        List<InternalObjectData> positionList = VehicleDataShare.getInstance().getList();
        ObjectsDataWS vehicleResponseData = new ObjectsDataWS();
        for (int i = 0; i < positionList.size(); i++) {
            InternalObjectData internalObjectData = positionList.get(i);
            vehicleResponseData.addPosition(internalObjectData.toObjectDataWS());
        }
        return vehicleResponseData;
    }


}
