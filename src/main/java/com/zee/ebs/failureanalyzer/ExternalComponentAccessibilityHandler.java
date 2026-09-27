package com.zee.ebs.failureanalyzer;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

/**
 * @dev : Ezekiel Eromosei
 * @date : 27 Sep, 2026
 */

@Component
public class ExternalComponentAccessibilityHandler {

    @Value("${api.url}")
    private String apiUrl;

    @EventListener(classes = ContextRefreshedEvent.class)
    public void listen(){

        RestClient restClient = RestClient.builder()
                .baseUrl(apiUrl)
                .build();

        ResponseEntity<Post> responseEntity = restClient.get()
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .toEntity(Post.class);

        if(!responseEntity.getStatusCode().is2xxSuccessful()){
            throw new ExternalComponentException(apiUrl);
        }
    }
}
