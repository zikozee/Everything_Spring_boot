package com.zee.ebs.environmentprocessor;


import org.jetbrains.annotations.NotNull;
import org.springframework.boot.EnvironmentPostProcessor;
import org.springframework.boot.SpringApplication;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MapPropertySource;

import java.util.HashMap;
import java.util.Map;

/**
 * @dev : Ezekiel Eromosei
 * @date : 15 Jun, 2026
 */

public class CustomEnvironmentProcessor implements EnvironmentPostProcessor {

    @Override
    public void postProcessEnvironment(@NotNull ConfigurableEnvironment environment, @NotNull SpringApplication application) {

        Map<String,Object> props = new HashMap<>();
        // load from vault or any external source.
        // you could loop through and add as many props as required
        props.put("app.region", "us-east-1");

        environment.getPropertySources()
                .addFirst(new MapPropertySource("customProps", props));
    }
}
