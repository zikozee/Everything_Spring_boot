package com.zee.ebs.startuplogic;


import com.zee.ebs.annotations.ZeeComponent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.env.Environment;

/**
 * @dev : Ezekiel Eromosei
 * @date : 24 May, 2026
 */

@Slf4j
@ZeeComponent
public class ConstructorStartup {

    private final Environment environment;


    public ConstructorStartup(Environment environment) {
        this.environment = environment;

        log.info("Constructor startup started {}", this.environment.getProperty("server.port"));
    }
}
