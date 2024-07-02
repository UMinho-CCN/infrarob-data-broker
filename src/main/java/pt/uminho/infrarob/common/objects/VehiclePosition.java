package pt.uminho.infrarob.common.objects;

public class VehiclePosition {
    private String vehicleID;
    private String vehicleType;
    private String lat;
    private String lon;
    private long lastUpdate;

    private boolean isInside;

    private int speed;
    private int acc;

    public VehiclePosition() {
    }

    public VehiclePosition(String vehicleID) {
        this.vehicleID = vehicleID;
    }

    public VehiclePosition(String vehicleID, String vehicleType, String lat, String lon, long lastUpdate, int speed, int acc ,boolean isInside) {
        this.vehicleID = vehicleID;
        this.vehicleType = vehicleType;
        this.lat = lat;
        this.lon = lon;
        this.lastUpdate = lastUpdate;
        this.isInside = isInside;
        this.speed = speed;
        this.acc = acc;
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

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLon() {
        return lon;
    }

    public void setLon(String lon) {
        this.lon = lon;
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

    public int getAcc() {
        return acc;
    }

    public void setAcc(int acc) {
        this.acc = acc;
    }

    @Override
    public String toString() {
        return "VehiclePosition{" +
                "vehicleID='" + vehicleID + '\'' +
                ", vehicleType='" + vehicleType + '\'' +
                ", lat='" + lat + '\'' +
                ", lon='" + lon + '\'' +
                ", lastUpdate=" + lastUpdate +
                ", isInside=" + isInside +
                ", speed=" + speed +
                ", acc=" + acc +
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
