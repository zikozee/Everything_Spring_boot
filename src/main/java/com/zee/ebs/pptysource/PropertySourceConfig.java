package com.zee.ebs.pptysource;


import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.core.env.Environment;

/**
 * @dev : Ezekiel Eromosei
 * @date : 06 Jul, 2026
 */

@Configuration

//@PropertySources(
//        value = {
//                @PropertySource("classpath:mycustom.properties"),
//                @PropertySource(value = "classpath:mycustom2.yaml", ignoreResourceNotFound = true, factory = YamlPropertySourceFactory.class)
//        }
//    )
@PropertySource("classpath:*custom*.properties")
@RequiredArgsConstructor
public class PropertySourceConfig implements CommandLineRunner {

    private final Environment env;

    @Override
    public void run(String... args) throws Exception {

        System.out.println("user: " + env.getProperty("username") + ", password: " + env.getProperty("password"));
        System.out.println("user1: " + env.getProperty("username1") + ", password1: " + env.getProperty("password1"));
        System.out.println("user2: " + env.getProperty("username2") + ", password2: " + env.getProperty("password2"));

    }
}
