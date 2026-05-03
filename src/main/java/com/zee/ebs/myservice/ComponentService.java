package com.zee.ebs.myservice;


import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * @dev : Ezekiel Eromosei
 * @date : 24 Apr, 2026
 */

@Slf4j
@Component
public class ComponentService implements CommandLineRunner {

    public ComponentService (){
        log.info("started Component service");
    }

    @Override
    public void run(String... args) throws Exception {
        log.info("ComponentService is running...");
        // You can add any initialization logic here
    }

    public String checkMe(){
        log.info("ComponentService is running...");
        return "WOOOO!!! this is working";
    }
}
