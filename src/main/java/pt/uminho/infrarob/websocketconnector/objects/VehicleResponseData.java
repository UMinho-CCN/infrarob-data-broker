package pt.uminho.infrarob.websocketconnector.objects;

import pt.uminho.infrarob.common.objects.VehiclePosition;

import java.util.ArrayList;
import java.util.List;

public class VehicleResponseData {
    private List<VehiclePosition> positionList;

    public VehicleResponseData(List<VehiclePosition> positionList) {
        this.positionList = positionList;
    }

    public VehicleResponseData() {
        this.positionList = new ArrayList<>();
    }

    public List<VehiclePosition> getPositionList() {
        return positionList;
    }

    public void setPositionList(List<VehiclePosition> positionList) {
        this.positionList = positionList;
    }

    public void addPosition(VehiclePosition vehiclePosition){
        positionList.add(vehiclePosition);
    }
}
