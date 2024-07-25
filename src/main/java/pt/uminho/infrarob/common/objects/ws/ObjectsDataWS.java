package pt.uminho.infrarob.common.objects.ws;

import java.util.ArrayList;
import java.util.List;

public class ObjectsDataWS {
    private List<ObjectDataWS> positionList;

    public ObjectsDataWS(List<ObjectDataWS> positionList) {
        this.positionList = positionList;
    }

    public ObjectsDataWS() {
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
