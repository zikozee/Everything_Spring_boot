package com.zee.ebs.springbootevents;


import org.springframework.boot.web.server.context.WebServerInitializedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * @dev : Ezekiel Eromosei
 * @date : 23 May, 2026
 */

@Component
public class WebServerInitializedEventListener {

    @EventListener
    public void onWebServerReady(WebServerInitializedEvent event) {
        System.out.println("WebServer Initialized Event Listener on the way ... " +  event.getWebServer().getPort());

        String[] beanDefinitionNames = event.getApplicationContext().getBeanDefinitionNames();
        System.out.println("first definition name: " + beanDefinitionNames[0]);

    }
}
