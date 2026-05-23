package com.zee.ebs.springbootevents;


import org.springframework.boot.context.event.ApplicationEnvironmentPreparedEvent;
import org.springframework.boot.context.event.ApplicationStartingEvent;
import org.springframework.context.ApplicationListener;

import java.util.Arrays;

/**
 * @dev : Ezekiel Eromosei
 * @date : 23 May, 2026
 */

public class EnvironmentPreparedEventListener implements ApplicationListener<ApplicationEnvironmentPreparedEvent> {

    @Override
    public void onApplicationEvent(ApplicationEnvironmentPreparedEvent event) {
        System.out.println("Application Environment Prepared Event Listener on the way ...  " + event.getTimestamp());
    }
}
