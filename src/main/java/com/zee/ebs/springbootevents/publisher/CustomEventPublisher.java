package com.zee.ebs.springbootevents.publisher;


import com.zee.ebs.EbsApplication;
import com.zee.ebs.annotations.ZeeComponent;
import com.zee.ebs.springbootevents.event.GenericEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationEventPublisher;

/**
 * @dev : Ezekiel Eromosei
 * @date : 23 May, 2026
 */

@ZeeComponent
@RequiredArgsConstructor
public class CustomEventPublisher implements CommandLineRunner {

    private final ApplicationEventPublisher applicationEventPublisher;

    @Override
    public void run(String... args) throws Exception {

        applicationEventPublisher.publishEvent(new GenericEvent(new SpringApplication(EbsApplication.class), new String[]{}, "ZEE"));

        Thread.sleep(20);
//        throw new RuntimeException();
    }
}
