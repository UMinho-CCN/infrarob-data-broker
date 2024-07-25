package pt.uminho.infrarob.common.objects.internal;

import pt.uminho.infrarob.common.objects.ws.PolygonCoordinatesWS;

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

    public PolygonCoordinatesWS toPolygonCoordinatesWS(){
        PolygonCoordinatesWS coordinatesWS = new PolygonCoordinatesWS();
        coordinatesWS.setLat(this.lat);
        coordinatesWS.setLng(this.lng);
        //coordinatesWS.setPosition(this.position);
        return coordinatesWS;
    }

    @Override
    public String toString() {
        return "PolygonCoordinates{" +
                "position=" + position +
                ", lat=" + lat +
                ", lng=" + lng +
                '}';
    }
}
