package com.zee.ebs.springbootevents;


import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * @dev : Ezekiel Eromosei
 * @date : 23 May, 2026
 */

@Component
public class ApplicationStartedEventListener {

    @EventListener
    public void appStarted(ApplicationStartedEvent event) {
        System.out.println("Application Started Event Listener ...");

    }
}
