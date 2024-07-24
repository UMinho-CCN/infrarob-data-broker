package pt.uminho.infrarob.common.objects.proto2;

import pt.uminho.infrarob.common.objects.internal.InternalObjectData;

public class Proto2ObjectData {
    private String objectID;
    private int speed;
    private int speedConfidence;
    private int longAcc;
    private int longAccConfidence;
    private int positionConfidence;
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

    public Proto2ObjectData() {
    }

    public Proto2ObjectData(String objectID, int speed, int speedConfidence, int longAcc, int longAccConfidence, int positionConfidence, int heading, int headingConfidence, int lat, int lon, int length, int lengthConfidence, int lane, int laneConfidence, int altitude, int altitudeConfidence, int vehicleLength, int vehicleLengthConfidence) {
        this.objectID = objectID;
        this.speed = speed;
        this.speedConfidence = speedConfidence;
        this.longAcc = longAcc;
        this.longAccConfidence = longAccConfidence;
        this.positionConfidence = positionConfidence;
        this.heading = heading;
        this.headingConfidence = headingConfidence;
        this.lat = lat;
        this.lon = lon;
        this.length = length;
        this.lengthConfidence = lengthConfidence;
        this.lane = lane;
        this.laneConfidence = laneConfidence;
        this.altitude = altitude;
        this.altitudeConfidence = altitudeConfidence;
        this.vehicleLength = vehicleLength;
        this.vehicleLengthConfidence = vehicleLengthConfidence;
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

    public int getPositionConfidence() {
        return positionConfidence;
    }

    public void setPositionConfidence(int positionConfidence) {
        this.positionConfidence = positionConfidence;
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



    @Override
    public String toString() {
        return "Proto2ObjectData{" +
                "objectID='" + objectID + '\'' +
                ", speed=" + speed +
                ", speedConfidence=" + speedConfidence +
                ", longAcc=" + longAcc +
                ", longAccConfidence=" + longAccConfidence +
                ", positionConfidence=" + positionConfidence +
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
                '}';
    }
}
