package com.zee.ebs.myservice;


import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.web.bind.annotation.RestController;

/**
 * @dev : Ezekiel Eromosei
 * @date : 24 Apr, 2026
 */

@Slf4j
@RestController
public class MyController implements CommandLineRunner {
//    public static final Logger logger = LoggerFactory.getLogger(MyController.class);

    @Override
    public void run(String... args) throws Exception {
        log.info("MyController is running...");
    }
}
