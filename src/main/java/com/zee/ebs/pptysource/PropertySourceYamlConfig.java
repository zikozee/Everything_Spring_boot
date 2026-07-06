package com.zee.ebs.pptysource;


import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

/**
 * @dev : Ezekiel Eromosei
 * @date : 06 Jul, 2026
 */

@Configuration
@PropertySource(value = "classpath:mycustom2.yaml", ignoreResourceNotFound = true, factory = YamlPropertySourceFactory.class)
@RequiredArgsConstructor
public class PropertySourceYamlConfig implements CommandLineRunner {

    private final Environment env;

    @Override
    public void run(String... args) throws Exception {

        System.out.println("yaml.user: " + env.getProperty("user.username") + ", yaml.password: " + env.getProperty("user.password"));

    }
}
