package com.zee.ebs.springbootevents.listener;


import com.zee.ebs.annotations.ZeeComponent;
import com.zee.ebs.springbootevents.event.GenericEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;

/**
 * @dev : Ezekiel Eromosei
 * @date : 23 May, 2026
 */

@Slf4j
@ZeeComponent
public class GenericEventListener {

    @EventListener(GenericEvent.class)
    public void  handleGenericEvent(GenericEvent event) {
        log.info("Listening on GenericEvent: {}", event.getUsername());
    }
}
