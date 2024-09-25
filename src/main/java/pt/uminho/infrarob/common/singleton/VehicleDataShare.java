package pt.uminho.infrarob.common.singleton;

import pt.uminho.infrarob.common.objects.internal.InternalObjectData;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class VehicleDataShare {


    private Map<String, InternalObjectData> vehiclePositionMap;
    private static VehicleDataShare instance = null;

    private VehicleDataShare() {
        vehiclePositionMap = new HashMap<>();
    }

    public static VehicleDataShare getInstance(){
        if(instance == null){
            instance = new VehicleDataShare();
        }

        return instance;
    }

    public void addVehiclePosition(InternalObjectData internalObjectData){
        InternalObjectData aux = internalObjectData;

        if (!vehiclePositionMap.containsKey(internalObjectData.getVehicleID())) {
            vehiclePositionMap.put(internalObjectData.getVehicleID(), internalObjectData);
        } else {
            internalObjectData = vehiclePositionMap.get(internalObjectData.getVehicleID());
        }

        internalObjectData.setLastUpdate(aux.getLastUpdate());
        internalObjectData.setLat(aux.getLat());
        internalObjectData.setLon(aux.getLon());

    }

    public InternalObjectData getVehiclePosition(String id){
        return vehiclePositionMap.get(id);
    }

    public void removePosition(String id){
        vehiclePositionMap.remove(id);
    }

    public List<InternalObjectData> getList(){
        return new ArrayList<>(vehiclePositionMap.values());
    }
}
