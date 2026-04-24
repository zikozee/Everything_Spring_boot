package com.zee.ebs.myservice;


import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

/**
 * @dev : Ezekiel Eromosei
 * @date : 24 Apr, 2026
 */

@Slf4j
@Service
public class SomeService implements CommandLineRunner{

    @Override
    public void run(String... args) throws Exception {
        log.info("SomeService is running...");
    }
}
