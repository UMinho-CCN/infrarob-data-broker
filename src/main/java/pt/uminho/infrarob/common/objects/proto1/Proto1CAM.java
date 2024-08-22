package pt.uminho.infrarob.common.objects.proto1;

import pt.uminho.infrarob.common.objects.internal.InternalObjectData;

public class Proto1CAM {
    private String objectID;
    private int speed;
    private int speedConfidence;
    private int longAcc;
    private int longAccConfidence;
    private int heading;
    private int headingConfidence;
    private int lat;
    private int lon;
    private int length;
    private int lengthConfidence;
    private int lane;
    private int laneConfidence;
    private int altitude;
    private int altitudeConfidence;
    private int vehicleLength;
    private int vehicleLengthConfidence;

    private int positionConfidence;

    public Proto1CAM() {
    }

    public String getObjectID() {
        return objectID;
    }

    public void setObjectID(String objectID) {
        this.objectID = objectID;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getSpeedConfidence() {
        return speedConfidence;
    }

    public void setSpeedConfidence(int speedConfidence) {
        this.speedConfidence = speedConfidence;
    }

    public int getLongAcc() {
        return longAcc;
    }

    public void setLongAcc(int longAcc) {
        this.longAcc = longAcc;
    }

    public int getLongAccConfidence() {
        return longAccConfidence;
    }

    public void setLongAccConfidence(int longAccConfidence) {
        this.longAccConfidence = longAccConfidence;
    }

    public int getHeading() {
        return heading;
    }

    public void setHeading(int heading) {
        this.heading = heading;
    }

    public int getHeadingConfidence() {
        return headingConfidence;
    }

    public void setHeadingConfidence(int headingConfidence) {
        this.headingConfidence = headingConfidence;
    }

    public int getLat() {
        return lat;
    }

    public void setLat(int lat) {
        this.lat = lat;
    }

    public int getLon() {
        return lon;
    }

    public void setLon(int lon) {
        this.lon = lon;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getLengthConfidence() {
        return lengthConfidence;
    }

    public void setLengthConfidence(int lengthConfidence) {
        this.lengthConfidence = lengthConfidence;
    }

    public int getLane() {
        return lane;
    }

    public void setLane(int lane) {
        this.lane = lane;
    }

    public int getLaneConfidence() {
        return laneConfidence;
    }

    public void setLaneConfidence(int laneConfidence) {
        this.laneConfidence = laneConfidence;
    }

    public int getAltitude() {
        return altitude;
    }

    public void setAltitude(int altitude) {
        this.altitude = altitude;
    }

    public int getAltitudeConfidence() {
        return altitudeConfidence;
    }

    public void setAltitudeConfidence(int altitudeConfidence) {
        this.altitudeConfidence = altitudeConfidence;
    }

    public int getVehicleLength() {
        return vehicleLength;
    }

    public void setVehicleLength(int vehicleLength) {
        this.vehicleLength = vehicleLength;
    }

    public int getVehicleLengthConfidence() {
        return vehicleLengthConfidence;
    }

    public void setVehicleLengthConfidence(int vehicleLengthConfidence) {
        this.vehicleLengthConfidence = vehicleLengthConfidence;
    }

    public int getPositionConfidence() {
        return positionConfidence;
    }

    public void setPositionConfidence(int positionConfidence) {
        this.positionConfidence = positionConfidence;
    }

    @Override
    public String toString() {
        return "Proto1CAM{" +
                "objectID='" + objectID + '\'' +
                ", speed=" + speed +
                ", speedConfidence=" + speedConfidence +
                ", longAcc=" + longAcc +
                ", longAccConfidence=" + longAccConfidence +
                ", heading=" + heading +
                ", headingConfidence=" + headingConfidence +
                ", lat=" + lat +
                ", lon=" + lon +
                ", length=" + length +
                ", lengthConfidence=" + lengthConfidence +
                ", lane=" + lane +
                ", laneConfidence=" + laneConfidence +
                ", altitude=" + altitude +
                ", altitudeConfidence=" + altitudeConfidence +
                ", vehicleLength=" + vehicleLength +
                ", vehicleLengthConfidence=" + vehicleLengthConfidence +
                ", positionConfidence=" + positionConfidence +
                '}';
    }

    public InternalObjectData toInternalObjectData(){
        InternalObjectData internalObjectData = new InternalObjectData();
        internalObjectData.setVehicleID(this.getObjectID());
        internalObjectData.setSpeed(this.getSpeed());
        internalObjectData.setSpeedConfidence(this.getSpeedConfidence());
        internalObjectData.setAccConvidence(this.getLongAccConfidence());
        internalObjectData.setAcc(this.getLongAcc());
        internalObjectData.setHeading(this.getHeading());
        internalObjectData.setHeadingConfidence(this.getHeadingConfidence());
        internalObjectData.setLat(this.getLat());
        internalObjectData.setLatConfidence(this.getPositionConfidence());
        internalObjectData.setLon(this.getLon());
        internalObjectData.setLonConfidence(this.getPositionConfidence());
        internalObjectData.setLength(this.getLength());
        internalObjectData.setLengthConfidence(this.getLengthConfidence());
        internalObjectData.setLane(this.getLane());
        internalObjectData.setLatConfidence(this.getLaneConfidence());
        internalObjectData.setAltitude(this.getAltitude());
        internalObjectData.setAltitudeConfidene(this.getAltitudeConfidence());
        internalObjectData.setLength(this.getVehicleLength());
        internalObjectData.setLengthConfidence(this.getVehicleLengthConfidence());
        return internalObjectData;
    }
}
