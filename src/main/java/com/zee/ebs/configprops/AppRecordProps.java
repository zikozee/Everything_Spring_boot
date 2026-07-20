package com.zee.ebs.configprops;


import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;

/**
 * @dev : Ezekiel Eromosei
 * @date : 20 Jul, 2026
 */

@ConfigurationProperties(prefix = "esb2")
public record AppRecordProps(
        String name,
        String ip,
        int port,
        Security security

) {

    public record Security(String token, boolean enabled, List<String> roles){}
}
