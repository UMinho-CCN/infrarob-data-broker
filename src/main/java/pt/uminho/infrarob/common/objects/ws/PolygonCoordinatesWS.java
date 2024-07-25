package pt.uminho.infrarob.common.objects.ws;

public class PolygonCoordinatesWS {
    private double lat;
    private double lng;

    public PolygonCoordinatesWS(double lat, double lon) {
        this.lat = lat;
        this.lng = lon;
    }

    public PolygonCoordinatesWS() {
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
        return "PolygonCoordinatesWS{" +
                "lat=" + lat +
                ", lng=" + lng +
                '}';
    }
}
