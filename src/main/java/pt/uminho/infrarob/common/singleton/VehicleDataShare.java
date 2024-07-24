package pt.uminho.infrarob.common.singleton;

import pt.uminho.infrarob.common.objects.internal.InternalObjectData;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        InternalObjectData veh;
        if(!vehiclePositionMap.containsKey(internalObjectData.getVehicleID())){
            veh = new InternalObjectData(internalObjectData.getVehicleID());
            veh.setVehicleType(internalObjectData.getVehicleType());
            vehiclePositionMap.put(internalObjectData.getVehicleID(), internalObjectData);
        }else{
            veh = vehiclePositionMap.get(internalObjectData.getVehicleID());
        }



        veh.setLastUpdate(internalObjectData.getLastUpdate());
        veh.setLat(internalObjectData.getLat());
        veh.setLon(internalObjectData.getLon());
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
