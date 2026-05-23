package com.zee.ebs.springbootevents;


import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * @dev : Ezekiel Eromosei
 * @date : 23 May, 2026
 */

@Component
public class ContextRefreshedEventListener {

    @EventListener
    public void onApplicationEvent(ContextRefreshedEvent event) {
        System.out.println("Context Refreshed Event Listener on the way: " + event.getApplicationContext().getId());
    }
}
