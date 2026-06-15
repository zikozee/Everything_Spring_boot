package com.zee.ebs.myservice;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @dev : Ezekiel Eromosei
 * @date : 24 Apr, 2026
 */

@Order(1)
@Slf4j
@Component
public class ComponentService implements CommandLineRunner {

    @Value("${app.region}")
    private String region;

    @Value("${external.api}")
    private String externalApi;

    public ComponentService (){
        log.info("started Component service");
    }

    @Override
    public void run(String... args) throws Exception {
        log.info("ComponentService is running...");
        // You can add any initialization logic here
        log.info("region from Post processor : {}", region);
        log.info("deploying to continent : {}", externalApi);
    }

    public String checkMe(){
        log.info("Within ComponentService ...");
        return "WOOOO!!! this is working";
    }
}
