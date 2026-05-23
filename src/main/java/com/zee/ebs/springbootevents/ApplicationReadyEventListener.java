package com.zee.ebs.springbootevents;


import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * @dev : Ezekiel Eromosei
 * @date : 23 May, 2026
 */

@Component
public class ApplicationReadyEventListener {

    @EventListener
    public void appStarted(ApplicationReadyEvent event) {
        System.out.println("Application Ready Event Listener ...");

    }
}
