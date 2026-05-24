package com.zee.ebs.startuplogic;

import com.zee.ebs.annotations.ZeeComponent;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.env.Environment;


/**
 * @dev : Ezekiel Eromosei
 * @date : 24 May, 2026
 */

@Slf4j
@ZeeComponent
@RequiredArgsConstructor
public class PostConstructStartup {
    private final Environment environment;

    @PostConstruct
    public void postConstruct() {
        log.info("PostConstructStartup:::::: is PostConstruct");

        log.info("PostConstructStartup:::::: {}", environment.getProperty("server.port", "6550"));
    }
}
