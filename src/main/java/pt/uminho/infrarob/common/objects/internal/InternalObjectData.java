package pt.uminho.infrarob.common.objects.internal;

import pt.uminho.infrarob.common.objects.proto2.Proto2Event;
import pt.uminho.infrarob.common.objects.proto2.Proto2ObjectData;
import pt.uminho.infrarob.common.objects.ws.ObjectDataWS;

public class InternalObjectData {
    private String vehicleID;
    private String vehicleType;
    private int lat;
    private int latConfidence;
    private int lon;
    private int lonConfidence;
    private long lastUpdate;

    private boolean isInside;

    private int speed;
    private int speedConfidence;
    private int acc;
    private int accConvidence;
    private int heading;
    private int headingConfidence;

    private int length;
    private int lengthConfidence;

    private int lane;
    private int laneConfidence;

    private int altitude;
    private int altitudeConfidene;

    private int timeStamp;

    public InternalObjectData() {
    }

    public InternalObjectData(String vehicleID) {
        this.vehicleID = vehicleID;
    }

    public InternalObjectData(String vehicleID, String vehicleType, int lat, int latConfidence, int lon, int lonConfidence, long lastUpdate, boolean isInside, int speed, int speedConfidence, int acc, int accConvidence, int heading, int headingConfidence, int length, int lengthConfidence, int lane, int laneConfidence, int altitude, int altitudeConfidene, int timeStamp) {
        this.vehicleID = vehicleID;
        this.vehicleType = vehicleType;
        this.lat = lat;
        this.latConfidence = latConfidence;
        this.lon = lon;
        this.lonConfidence = lonConfidence;
        this.lastUpdate = lastUpdate;
        this.isInside = isInside;
        this.speed = speed;
        this.speedConfidence = speedConfidence;
        this.acc = acc;
        this.accConvidence = accConvidence;
        this.heading = heading;
        this.headingConfidence = headingConfidence;
        this.length = length;
        this.lengthConfidence = lengthConfidence;
        this.lane = lane;
        this.laneConfidence = laneConfidence;
        this.altitude = altitude;
        this.altitudeConfidene = altitudeConfidene;
        this.timeStamp = timeStamp;
    }

    public String getVehicleID() {
        return vehicleID;
    }

    public void setVehicleID(String vehicleID) {
        this.vehicleID = vehicleID;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public int getLat() {
        return lat;
    }

    public double getConvertedLat(){
        return (double)this.lat/10000000;
    }

    public double getConvertedLon(){
        return (double)this.lon/10000000;
    }

    public void setLat(int lat) {
        this.lat = lat;
    }

    public int getLatConfidence() {
        return latConfidence;
    }

    public void setLatConfidence(int latConfidence) {
        this.latConfidence = latConfidence;
    }

    public int getLon() {
        return lon;
    }

    public void setLon(int lon) {
        this.lon = lon;
    }

    public int getLonConfidence() {
        return lonConfidence;
    }

    public void setLonConfidence(int lonConfidence) {
        this.lonConfidence = lonConfidence;
    }

    public long getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(long lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public boolean isInside() {
        return isInside;
    }

    public void setInside(boolean inside) {
        isInside = inside;
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

    public int getAcc() {
        return acc;
    }

    public void setAcc(int acc) {
        this.acc = acc;
    }

    public int getAccConvidence() {
        return accConvidence;
    }

    public void setAccConvidence(int accConvidence) {
        this.accConvidence = accConvidence;
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

    public int getAltitudeConfidene() {
        return altitudeConfidene;
    }

    public void setAltitudeConfidene(int altitudeConfidene) {
        this.altitudeConfidene = altitudeConfidene;
    }

    public int getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(int timeStamp) {
        this.timeStamp = timeStamp;
    }

    public ObjectDataWS toObjectDataWS(){
        ObjectDataWS objectDataWS = new ObjectDataWS();
        objectDataWS.setObjectID(this.getVehicleID());
        objectDataWS.setLat((double) this.getLat() /10000000);
        objectDataWS.setLon((double) this.getLon() /10000000);
        objectDataWS.setVelocity(this.getSpeed());
        return objectDataWS;
    }

    public Proto2ObjectData toProto2ObjectData(){
        Proto2ObjectData data = new Proto2ObjectData();
        data.setObjectID(this.getVehicleID());
        data.setSpeed(this.getSpeed());
        data.setSpeedConfidence(this.getSpeedConfidence());
        data.setLongAcc(this.getAcc());
        data.setLongAccConfidence(this.getAccConvidence());
        data.setPositionConfidence(this.getLonConfidence());
        data.setHeading(this.getHeading());
        data.setHeadingConfidence(this.getHeadingConfidence());
        data.setLat(this.getLat());
        data.setLon(this.getLon());
        data.setLength(this.getLengthConfidence());
        data.setLane(this.getLane());
        data.setLaneConfidence(this.getLaneConfidence());
        data.setAltitude(this.getAltitude());
        data.setAltitudeConfidence(this.getAltitudeConfidene());
        data.setVehicleLength(this.getLength());
        data.setVehicleLengthConfidence(this.getLengthConfidence());

        return data;
    }

    @Override
    public String toString() {
        return "InternalObjectData{" +
                "vehicleID='" + vehicleID + '\'' +
                ", vehicleType='" + vehicleType + '\'' +
                ", lat=" + lat +
                ", latConfidence=" + latConfidence +
                ", lon=" + lon +
                ", lonConfidence=" + lonConfidence +
                ", lastUpdate=" + lastUpdate +
                ", isInside=" + isInside +
                ", speed=" + speed +
                ", speedConfidence=" + speedConfidence +
                ", acc=" + acc +
                ", accConvidence=" + accConvidence +
                ", heading=" + heading +
                ", headingConfidence=" + headingConfidence +
                ", length=" + length +
                ", lengthConfidence=" + lengthConfidence +
                ", lane=" + lane +
                ", laneConfidence=" + laneConfidence +
                ", altitude=" + altitude +
                ", altitudeConfidene=" + altitudeConfidene +
                ", timeStamp=" + timeStamp +
                '}';
    }

    public String toStringWithID(long id) {
        return "{" +
                "\"vehicleID\":\"" + vehicleID + "\"," +
                "\"vehicleType\":\"" + vehicleType + "\"," +
                "\"lat\":\"" + lat + "\"," +
                "\"lon\":\"" + lon + "\"," +
                "\"speed\":\"" + speed + "\"," +
                "\"acc\":\"" + acc + "\"," +
                "\"lastUpdate\":\"" + lastUpdate + "\"," +
                "\"messageID\":\"" + id + "\"" +
                '}';
    }
}
