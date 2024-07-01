package pt.uminho.infrarob.websocketconnector.objects;

public class PolygonCoordinates {
    private int position;
    private double lat;
    private double lng;

    public PolygonCoordinates(double lat, double lon, int position) {
        this.lat = lat;
        this.lng = lon;
        this.position = position;
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

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return "PolygonCoordinates{" +
                "lat=" + lat +
                ", lng=" + lng +
                '}';
    }
}
