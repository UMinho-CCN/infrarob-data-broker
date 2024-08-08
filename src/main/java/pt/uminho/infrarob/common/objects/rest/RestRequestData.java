package pt.uminho.infrarob.common.objects.rest;

import com.fasterxml.jackson.annotation.JsonProperty;
import pt.uminho.infrarob.common.objects.proto2.Proto2Objects;

public class RestRequestData {
    @JsonProperty("input_data")
    private Proto2Objects proto2Objects;

    public RestRequestData(Proto2Objects proto2Objects) {
        this.proto2Objects = proto2Objects;
    }

    public Proto2Objects getProto2Objects() {
        return proto2Objects;
    }

    public void setProto2Objects(Proto2Objects proto2Objects) {
        this.proto2Objects = proto2Objects;
    }
}
