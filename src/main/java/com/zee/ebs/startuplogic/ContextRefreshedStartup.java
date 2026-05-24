package com.zee.ebs.startuplogic;


import com.zee.ebs.EbsApplication;
import com.zee.ebs.myservice.StartupContextRefreshedEventService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.core.env.Environment;

/**
 * @dev : Ezekiel Eromosei
 * @date : 24 May, 2026
 */

@Slf4j
@RequiredArgsConstructor
public class ContextRefreshedStartup implements ApplicationListener<ContextRefreshedEvent> {

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {


        ApplicationContext context = EbsApplication.getContext();
        StartupContextRefreshedEventService refreshedEventService = context.getBean(StartupContextRefreshedEventService.class);
        log.info("ContextRefreshedStartup: {}", refreshedEventService.doingRealWork());

        Environment env = context.getBean(Environment.class);
        String property = env.getProperty("context-text");
        log.info("ContextRefreshedStartup:::::: is Context-Test {}", property.equals("Zee_EBS"));
    }
}
