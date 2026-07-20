package com.zee.ebs.configprops;


import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;

/**
 * @dev : Ezekiel Eromosei
 * @date : 20 Jul, 2026
 */

@Getter
@AllArgsConstructor
@ConfigurationProperties(prefix = "esb")
public class AppProperties {
    private final String name;
    private final String ip;
    private final int port;

    private Security security;


    @Getter
    @AllArgsConstructor
    public static class Security {
        private String token;
        private boolean enabled;
        private List<String> roles;
    }

}
