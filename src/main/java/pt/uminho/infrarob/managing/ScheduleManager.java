package pt.uminho.infrarob.managing;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import pt.uminho.infrarob.common.objects.internal.InternalObjectData;
import pt.uminho.infrarob.common.singleton.VehicleDataShare;
import pt.uminho.infrarob.events.events.RequestRESTDataEvent;

import java.util.ArrayList;

@Component
public class ScheduleManager {
    long lastUpdate = 0;
    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;
    @Scheduled(fixedRate = 100)
    public void cleanNoUpdated(){
        if (lastUpdate == 0){
            lastUpdate = System.currentTimeMillis();
        }

        ArrayList<InternalObjectData> positionList = new ArrayList<>(VehicleDataShare.getInstance().getList());
        long time = System.currentTimeMillis();
        for (int i = 0; i < positionList.size(); i++) {
            InternalObjectData internalObjectData = positionList.get(i);
            if(time - internalObjectData.getLastUpdate() >= 30000){
                VehicleDataShare.getInstance().removePosition(internalObjectData.getVehicleID());
            }
        }

        if(System.currentTimeMillis() - lastUpdate > 1000){
            lastUpdate = System.currentTimeMillis();
            RequestRESTDataEvent requestRESTDataEvent = new RequestRESTDataEvent(this);
            applicationEventPublisher.publishEvent(requestRESTDataEvent);
        }

    }
}
