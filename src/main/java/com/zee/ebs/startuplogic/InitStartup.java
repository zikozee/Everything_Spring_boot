package com.zee.ebs.startuplogic;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.env.Environment;

/**
 * @dev : Ezekiel Eromosei
 * @date : 24 May, 2026
 */

@Slf4j
@RequiredArgsConstructor
public class InitStartup {

    private final Environment environment;

    public String myInitMethod() {
       log.info("Init BeanStartup::::::::{}", environment.getProperty("server.port"));

       return environment.getProperty("server.port");
    }
}
