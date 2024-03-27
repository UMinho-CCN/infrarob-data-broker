package pt.uminho.infrarob.common.singleton;

import pt.uminho.infrarob.common.objects.VehiclePosition;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VehicleDataShare {
    private Map<String, VehiclePosition> vehiclePositionMap;
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

    public void addVehiclePosition(VehiclePosition vehiclePosition){
        VehiclePosition veh;
        if(!vehiclePositionMap.containsKey(vehiclePosition.getVehicleID())){
            veh = new VehiclePosition(vehiclePosition.getVehicleID());
            veh.setVehicleType(vehiclePosition.getVehicleType());
            vehiclePositionMap.put(vehiclePosition.getVehicleID(), vehiclePosition);
        }else{
            veh = vehiclePositionMap.get(vehiclePosition.getVehicleID());
        }



        veh.setLastUpdate(vehiclePosition.getLastUpdate());
        veh.setLat(vehiclePosition.getLat());
        veh.setLon(vehiclePosition.getLon());
    }

    public void removePosition(String id){
        vehiclePositionMap.remove(id);
    }

    public List<VehiclePosition> getList(){
        return new ArrayList<>(vehiclePositionMap.values());
    }
}
