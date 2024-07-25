package pt.uminho.infrarob.events.listners;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.event.EventListener;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;
import pt.uminho.infrarob.common.objects.internal.InternalObjectData;
import pt.uminho.infrarob.common.objects.proto2.Proto2Objects;
import pt.uminho.infrarob.events.events.V2xMessageOutputEvent;

import java.util.List;

@Component
public class RestOutputEvenManager {

    @Value("${rest.output.uri}")
    private String REST_URI;
    @Async
    @EventListener
    public void handleData(V2xMessageOutputEvent outputEvent){
        if(outputEvent.getData().getObjects() != null && !outputEvent.getData().getObjects().isEmpty()){
            handleObjectData(outputEvent);
        }
        if(outputEvent.getData().getObjects() != null && !outputEvent.getData().getEvents().isEmpty()){
            handleEventData(outputEvent);
        }
    }

    private void handleObjectData(V2xMessageOutputEvent outputEvent){
        Proto2Objects proto2Objects = new Proto2Objects();
        for (int i = 0; i < outputEvent.getData().getObjects().size(); i++) {
            InternalObjectData internalObjectData = outputEvent.getData().getObjects().get(i);
            proto2Objects.addData(internalObjectData.toProto2ObjectData());
        }
        ObjectMapper mapper = new ObjectMapper();

        RestClient restClient = RestClient.create();
        try {
            ResponseEntity responseEntity = restClient
                    .post()
                    .uri("REST_URI")
                    .body(mapper.writeValueAsString(proto2Objects))
                    .header("Authorization", "Bearer: " + "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJyb2xlIjoiaW5mcmFyb2JfdXNlcnMiLCJ1c2VyIjoidjJ4X3VzZXIifQ.kV39NUCvYcqAWVueDbNpv1VxeT1dYqitngzSwoLuYdY")
                    .contentType(MediaType.APPLICATION_JSON)
                    .retrieve().toBodilessEntity();
        } catch (Exception e) {
            //e.printStackTrace();
        }
    }

    private void handleEventData(V2xMessageOutputEvent outputEvent){
        Proto2Objects proto2Objects = new Proto2Objects();
        proto2Objects.addEvent(outputEvent.getData().getEvents().get(0).toProto2Event());

        List<InternalObjectData> objects = outputEvent.getData().getObjects();

        for (int i = 0; i < objects.size(); i++) {
            InternalObjectData internalObjectData = objects.get(i);
            proto2Objects.addData(internalObjectData.toProto2ObjectData());
        }

        ObjectMapper mapper = new ObjectMapper();

        RestClient restClient = RestClient.create();

        try {

            ResponseEntity responseEntity = restClient
                    .post()
                    .uri("REST_URI")
                    .body(mapper.writeValueAsString(proto2Objects))
                    .header("Authorization", "Bearer: " + "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJyb2xlIjoiaW5mcmFyb2JfdXNlcnMiLCJ1c2VyIjoidjJ4X3VzZXIifQ.kV39NUCvYcqAWVueDbNpv1VxeT1dYqitngzSwoLuYdY")
                    .contentType(MediaType.APPLICATION_JSON)
                    .retrieve().toBodilessEntity();
        } catch (Exception e) {
            //e.printStackTrace();
        }
    }
}
