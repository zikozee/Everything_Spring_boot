package com.zee.ebs.logging;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @dev : Ezekiel Eromosei
 * @date : 04 Sep, 2026
 */

@Configuration
public class LoggingConfiguration {

    @Bean
    FilterRegistrationBean<MdcFilter> mdcFilterRegistration(@Value("${spring.application.name}") String applicationName) {
        FilterRegistrationBean<MdcFilter> registrationBean = new FilterRegistrationBean<>(new MdcFilter(applicationName));

        registrationBean.setName("mdcFilter");
        registrationBean.addUrlPatterns("/*");
        registrationBean.setOrder(2);

        return registrationBean;
    }
}
