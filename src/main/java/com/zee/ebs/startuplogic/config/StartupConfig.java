package com.zee.ebs.startuplogic.config;


import com.zee.ebs.startuplogic.InitStartup;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

/**
 * @dev : Ezekiel Eromosei
 * @date : 24 May, 2026
 */

@Configuration
@RequiredArgsConstructor
public class StartupConfig {
    private final Environment environment;

    @Bean(initMethod = "myInitMethod")
    InitStartup initBeanStartup() {
        return new InitStartup(environment);
    }
}
