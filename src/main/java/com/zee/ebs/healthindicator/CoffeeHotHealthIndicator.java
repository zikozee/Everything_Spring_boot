package com.zee.ebs.healthindicator;


import org.jspecify.annotations.Nullable;
import org.springframework.boot.health.contributor.Health;
import org.springframework.boot.health.contributor.HealthIndicator;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;
import tools.jackson.databind.ObjectMapper;

import java.util.List;
import java.util.Map;

/**
 * @dev : Ezekiel Eromosei
 * @date : 21 Jun, 2026
 */

@Component
public class CoffeeHotHealthIndicator implements HealthIndicator {
    @Override
    public @Nullable Health health() {
        //https://api.sampleapis.com/coffee/hot

        try {
            RestClient restClient = RestClient.builder()
                    .baseUrl("https://api.sampleapis.com")
                    .build();

            ResponseEntity<List<CoffeeHotDto>> responseEntity = restClient.get()
                    .uri("/coffee/hot")
                    .accept(MediaType.APPLICATION_JSON)
                    .retrieve()
                    .toEntity(new ParameterizedTypeReference<>() {
                    });

            ObjectMapper objectMapper = new ObjectMapper();

            if (responseEntity.getStatusCode().is2xxSuccessful()) {
                return Health.up()
                        .withDetails(objectMapper.convertValue(responseEntity.getBody().getFirst(), Map.class))
                        .build();

            }else {
                return Health.down()
                        .withDetail("status", responseEntity.getStatusCode().toString())
                        .build();
            }

        }catch (Exception e){

            return Health.down()
                    .withException(e)
                    .build();
        }


    }
}
