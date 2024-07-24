package pt.uminho.infrarob.common.objects.ws;

public class PolygonCoordinatesWS {
    private int position;
    private double lat;
    private double lng;

    public PolygonCoordinatesWS(double lat, double lon, int position) {
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
        return "PolygonCoordinatesWS{" +
                "lat=" + lat +
                ", lng=" + lng +
                '}';
    }
}
