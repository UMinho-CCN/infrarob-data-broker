package pt.uminho.infrarob.websocketconnector.objects;

public class PolygonCoordinates {
    private double lat;
    private double lng;

    public PolygonCoordinates(double lat, double lon) {
        this.lat = lat;
        this.lng = lon;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }

    @Override
    public String toString() {
        return "PolygonCoordinates{" +
                "lat=" + lat +
                ", lng=" + lng +
                '}';
    }
}
