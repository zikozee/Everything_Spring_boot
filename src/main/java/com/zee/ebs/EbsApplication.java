package com.zee.ebs;

import com.zee.ebs.configprops.AppProperties;
import com.zee.ebs.configprops.AppRecordProps;
import com.zee.ebs.springbootevents.ContextInitializedEventListener;
import com.zee.ebs.springbootevents.EnvironmentPreparedEventListener;
import com.zee.ebs.springbootevents.StartingEventListener;
import com.zee.ebs.springbootevents.PreparedEvent;
import com.zee.ebs.startuplogic.ContextRefreshedStartup;
import lombok.Getter;
import org.springframework.beans.BeansException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

@EnableConfigurationProperties(value = {AppProperties.class, AppRecordProps.class})
@SpringBootApplication
public class EbsApplication implements ApplicationContextAware {

    @Getter
    private static ApplicationContext context;

    public static void main(String[] args) {
//        SpringApplication.run(EbsApplication.class, args);
        SpringApplication app = new SpringApplication(EbsApplication.class);
        app.addListeners(
                new StartingEventListener(),
                new EnvironmentPreparedEventListener(),
                new ContextInitializedEventListener(),
                new PreparedEvent(),
                new ContextRefreshedStartup()
        );
        app.run(args);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        context = applicationContext;
    }
}
