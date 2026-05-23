package com.zee.ebs.springbootevents;


import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationStartingEvent;
import org.springframework.context.ApplicationListener;

/**
 * @dev : Ezekiel Eromosei
 * @date : 23 May, 2026
 */

public class StartingEventListener implements ApplicationListener<ApplicationStartingEvent> {

    @Override
    public void onApplicationEvent(ApplicationStartingEvent event) {
        System.out.println("Application starting Event Listener on the way ...  " + event.getTimestamp());
    }
}
