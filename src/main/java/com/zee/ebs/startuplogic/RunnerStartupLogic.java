package com.zee.ebs.startuplogic;


import com.zee.ebs.annotations.ZeeComponent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.env.Environment;

/**
 * @dev : Ezekiel Eromosei
 * @date : 24 May, 2026
 */

@Slf4j
@ZeeComponent
@RequiredArgsConstructor
public class RunnerStartupLogic implements ApplicationRunner {
    private final Environment environment;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        log.info("Runner startup logic started: {}", environment.getProperty("server.port"));
    }
}
