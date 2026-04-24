package com.zee.ebs.myservice;


import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Repository;

/**
 * @dev : Ezekiel Eromosei
 * @date : 24 Apr, 2026
 */

@Slf4j
@Repository
public class Repo implements CommandLineRunner{
    @Override
    public void run(String... args) throws Exception {
        log.info("Repo is running...");
    }
}
