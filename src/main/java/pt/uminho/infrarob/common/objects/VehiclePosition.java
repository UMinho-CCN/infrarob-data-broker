package pt.uminho.infrarob.common.objects;

public class VehiclePosition {
    private String vehicleID;
    private String vehicleType;
    private String lat;
    private String lon;
    private long lastUpdate;

    public VehiclePosition() {
    }

    public VehiclePosition(String vehicleID) {
        this.vehicleID = vehicleID;
    }

    public VehiclePosition(String vehicleID, String vehicleType, String lat, String lon, long lastUpdate) {
        this.vehicleID = vehicleID;
        this.vehicleType = vehicleType;
        this.lat = lat;
        this.lon = lon;
        this.lastUpdate = lastUpdate;
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

    @Override
    public String toString() {
        return "{" +
                "\"vehicleID\":\"" + vehicleID + "\"," +
                "\"vehicleType\":\"" + vehicleType + "\"," +
                "\"lat\":\"" + lat + "\"," +
                "\"lon\":\"" + lon + "\"," +
                "\"lastUpdate\":\"" + lastUpdate + "\"" +
                '}';
    }

    public String toStringWithID(long id) {
        return "{" +
                "\"vehicleID\":\"" + vehicleID + "\"," +
                "\"vehicleType\":\"" + vehicleType + "\"," +
                "\"lat\":\"" + lat + "\"," +
                "\"lon\":\"" + lon + "\"," +
                "\"lastUpdate\":\"" + lastUpdate + "\"," +
                "\"messageID\":\"" + id + "\"" +
                '}';
    }
}
