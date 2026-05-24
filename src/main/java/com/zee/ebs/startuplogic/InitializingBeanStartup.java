package com.zee.ebs.startuplogic;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

/**
 * @dev : Ezekiel Eromosei
 * @date : 24 May, 2026
 */

@Slf4j
@Component
@RequiredArgsConstructor
public class InitializingBeanStartup implements InitializingBean {

    private final Environment environment;

    @Override
    public void afterPropertiesSet() throws Exception {

        log.info("InitializingBeanStartup:::::: {}", environment.getProperty( "server.port", "6550" ));
    }
}
