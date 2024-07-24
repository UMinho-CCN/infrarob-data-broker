package pt.uminho.infrarob.common.objects.ws;

import pt.uminho.infrarob.common.objects.internal.InternalObjectData;

import java.util.ArrayList;
import java.util.List;

public class VehicleResponseDataWS {
    private List<ObjectDataWS> positionList;

    public VehicleResponseDataWS(List<ObjectDataWS> positionList) {
        this.positionList = positionList;
    }

    public VehicleResponseDataWS() {
        this.positionList = new ArrayList<>();
    }

    public List<ObjectDataWS> getPositionList() {
        return positionList;
    }

    public void setPositionList(List<ObjectDataWS> positionList) {
        this.positionList = positionList;
    }

    public void addToList(ObjectDataWS data){
        this.positionList.add(data);
    }

    public void addPosition(ObjectDataWS internalObjectData){
        positionList.add(internalObjectData);
    }


}
