package pt.uminho.infrarob.common.objects.rpa;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;
@JsonIgnoreProperties(ignoreUnknown = true)
public class RPAData {
    private List<RPAObject> data;
    private int timestamp;

    public RPAData() {
    }

    public RPAData(List<RPAObject> data, int timestamp) {
        this.data = data;
        this.timestamp = timestamp;
    }

    public List<RPAObject> getData() {
        return data;
    }

    public void setData(List<RPAObject> data) {
        this.data = data;
    }

    public int getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(int timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "RPAData{" +
                "data=" + data +
                ", timestamp=" + timestamp +
                '}';
    }
}
