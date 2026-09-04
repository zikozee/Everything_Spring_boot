package com.zee.ebs.logging;


import org.springframework.boot.EnvironmentPostProcessor;
import org.springframework.boot.SpringApplication;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MapPropertySource;

import java.util.Map;

/**
 * @dev : Ezekiel Eromosei
 * @date : 04 Sep, 2026
 */

public class StructuredLoggingEnvironmentPostProcessor implements EnvironmentPostProcessor {

    @Override
    public void postProcessEnvironment(ConfigurableEnvironment environment, SpringApplication application) {
        boolean enabled = environment.getProperty("logging.structured.enabled", Boolean.class, true);

        if(enabled){
            Map<String, Object> props = Map.of("logging.structured.format.console",
                    "com.zee.ebs.logging.ESBStructuredLoggerFormatter");

            environment.getPropertySources()
                    .addFirst(new MapPropertySource("structuredLogging", props));
        }

    }
}
