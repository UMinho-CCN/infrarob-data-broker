package pt.uminho.infrarob.managing;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import pt.uminho.infrarob.common.objects.internal.InternalObjectData;
import pt.uminho.infrarob.common.singleton.VehicleDataShare;

import java.util.ArrayList;

@Component
public class ScheduleManager {
    @Scheduled(fixedRate = 30000)
    public void cleanNoUpdated(){
        ArrayList<InternalObjectData> positionList = new ArrayList<>(VehicleDataShare.getInstance().getList());
        long time = System.currentTimeMillis();
        for (int i = 0; i < positionList.size(); i++) {
            InternalObjectData internalObjectData = positionList.get(i);
            if(time - internalObjectData.getLastUpdate() >= 30000){
                VehicleDataShare.getInstance().removePosition(internalObjectData.getVehicleID());
            }
        }
    }
}
