package pt.uminho.infrarob.udpconnector.service;

import org.springframework.messaging.Message;
import org.springframework.stereotype.Service;
import pt.uminho.infrarob.common.objects.VehiclePosition;
import pt.uminho.infrarob.common.singleton.VehicleDataShare;


@Service
public class UDPService {
    public void receive(Message message){
        String data = new String((byte[]) message.getPayload());
        String posData[] = data.split(";");
        double lon = Double.parseDouble(posData[1])/10000000;
        double lat = Double.parseDouble(posData[2])/10000000;

        System.out.println("Received Data: " + data);

        VehiclePosition vehiclePosition = new VehiclePosition(posData[0], "", String.valueOf(lat), String.valueOf(lon), System.currentTimeMillis());
        VehicleDataShare.getInstance().addVehiclePosition(vehiclePosition);
    }
}
