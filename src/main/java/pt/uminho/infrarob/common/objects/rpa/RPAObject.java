package pt.uminho.infrarob.common.objects.rpa;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import pt.uminho.infrarob.common.objects.internal.InternalObjectData;
import pt.uminho.infrarob.common.objects.proto2.Proto2ObjectData;

import java.util.Arrays;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RPAObject {
    private double [] acceleration;
    private int acc_conf;
    private double[] position;
    private int pos_conf;
    private double [] velocity;
    private int vel_conf;
    private String _id;

    public RPAObject() {
    }

    public RPAObject(double [] acceleration, int acc_conf, double[] position, int pos_conf, double[] velocity, int vel_conf, String _id) {
        this.acceleration = acceleration;
        this.acc_conf = acc_conf;
        this.position = position;
        this.pos_conf = pos_conf;
        this.velocity = velocity;
        this.vel_conf = vel_conf;
        this._id = _id;
    }

    public double [] getAcceleration() {
        return acceleration;
    }

    public void setAcceleration(double [] acceleration) {
        this.acceleration = acceleration;
    }

    public int getAcc_conf() {
        return acc_conf;
    }

    public void setAcc_conf(int acc_conf) {
        this.acc_conf = acc_conf;
    }

    public double[] getPosition() {
        return position;
    }

    public void setPosition(double[] position) {
        this.position = position;
    }

    public int getPos_conf() {
        return pos_conf;
    }

    public void setPos_conf(int pos_conf) {
        this.pos_conf = pos_conf;
    }

    public double[] getVelocity() {
        return velocity;
    }

    public void setVelocity(double[] velocity) {
        this.velocity = velocity;
    }

    public int getVel_conf() {
        return vel_conf;
    }

    public void setVel_conf(int vel_conf) {
        this.vel_conf = vel_conf;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    @Override
    public String toString() {
        return "RPAObject{" +
                "acceleration=" + Arrays.toString(acceleration) +
                ", acc_conf=" + acc_conf +
                ", position=" + Arrays.toString(position) +
                ", pos_conf=" + pos_conf +
                ", velocity=" + Arrays.toString(velocity) +
                ", vel_conf=" + vel_conf +
                ", _id='" + _id + '\'' +
                '}';
    }

    public InternalObjectData toInternalData(){
        InternalObjectData internalObjectData = new InternalObjectData();
        internalObjectData.setAcc((int)(this.getAcceleration()[0]));
        internalObjectData.setAccConvidence(this.getAcc_conf());
        internalObjectData.setVehicleID(this.get_id());
        internalObjectData.setSpeed((int)(this.getVelocity()[0]));
        internalObjectData.setSpeedConfidence(this.getVel_conf());
        internalObjectData.setLat((int)((this.getPosition()[0])*(double)10000000));
        internalObjectData.setLon((int)((this.getPosition()[1])*(double)10000000));
        internalObjectData.setLatConfidence(this.getPos_conf());
        internalObjectData.setLonConfidence(this.getPos_conf());
        //internalObjectData.setVehicleType(this.);
        return internalObjectData;
    }
}
