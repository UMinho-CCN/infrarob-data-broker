package pt.uminho.infrarob.events.listners;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;
import pt.uminho.infrarob.common.objects.internal.InternalEventData;
import pt.uminho.infrarob.common.objects.rpa.RPAData;
import pt.uminho.infrarob.common.objects.rpa.RPAObject;
import pt.uminho.infrarob.events.events.RequestRESTDataEvent;
import pt.uminho.infrarob.events.events.V2XMessageReceivedEvent;

@Component
@Profile("rest-in")
public class RESTRequestEventManager {

    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;
    @Async
    @EventListener
    public void requestRESTData(RequestRESTDataEvent requestRESTDataEvent){
        RestClient restClient = RestClient.create();
        ResponseEntity responseEntity = restClient
                .get()
                .uri("http://192.168.43.2:5000/entities")
                .retrieve().toEntity(String.class);

        //System.out.println(responseEntity.toString());

        if(responseEntity.getStatusCode().value() != 200){
            return;
        }
        ObjectMapper mapper = new ObjectMapper();
        try {
            RPAData data = mapper.readValue(responseEntity.getBody().toString(), RPAData.class);
            for (int i = 0; i < data.getData().size(); i++) {
                RPAObject rpaObject = data.getData().get(i);

                V2XMessageReceivedEvent event = new V2XMessageReceivedEvent(this, rpaObject.toInternalData());
                applicationEventPublisher.publishEvent(event);
            }

        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}
