package com.zee.ebs.springbootevents;


import org.springframework.boot.context.event.ApplicationPreparedEvent;
import org.springframework.context.ApplicationListener;

/**
 * @dev : Ezekiel Eromosei
 * @date : 23 May, 2026
 */

public class PreparedEvent implements ApplicationListener<ApplicationPreparedEvent> {


    @Override
    public void onApplicationEvent(ApplicationPreparedEvent event) {
        String property = event.getApplicationContext().getEnvironment().getProperty("spring.application.name");
        System.out.println("Application Prepared Event received: " +  property);

    }
}
