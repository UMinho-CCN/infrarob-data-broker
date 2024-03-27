package pt.uminho.infrarob.managing;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import pt.uminho.infrarob.common.objects.VehiclePosition;
import pt.uminho.infrarob.common.singleton.VehicleDataShare;

import java.util.ArrayList;

@Component
public class ScheduleCleaner {
    @Scheduled(fixedRate = 5000)
    public void cleanNoUpdated(){
        ArrayList<VehiclePosition> positionList = new ArrayList<>(VehicleDataShare.getInstance().getList());
        long time = System.currentTimeMillis();
        for (int i = 0; i < positionList.size(); i++) {
            VehiclePosition vehiclePosition = positionList.get(i);
            if(time - vehiclePosition.getLastUpdate() >= 5000){
                VehicleDataShare.getInstance().removePosition(vehiclePosition.getVehicleID());
            }
        }
    }
}
