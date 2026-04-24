package com.zee.ebs.myservice;


import com.zee.ebs.annotations.ZeeComponent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;

/**
 * @dev : Ezekiel Eromosei
 * @date : 24 Apr, 2026
 */

@Slf4j
@ZeeComponent
public class MyCustomService implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        log.info("========>>>>>>>>>Zee Component:: MyCustomService is running...");
    }
}
