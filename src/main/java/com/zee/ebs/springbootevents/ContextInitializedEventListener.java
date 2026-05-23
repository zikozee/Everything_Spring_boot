package com.zee.ebs.springbootevents;


import org.springframework.boot.context.event.ApplicationContextInitializedEvent;
import org.springframework.boot.context.event.ApplicationEnvironmentPreparedEvent;
import org.springframework.context.ApplicationListener;

/**
 * @dev : Ezekiel Eromosei
 * @date : 23 May, 2026
 */

public class ContextInitializedEventListener implements ApplicationListener<ApplicationContextInitializedEvent> {

    @Override
    public void onApplicationEvent(ApplicationContextInitializedEvent event) {
        System.out.println("AApplication Context Initialized Event Event Listener on the way ...  " + event.getTimestamp());
    }
}
