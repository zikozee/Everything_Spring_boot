package com.zee.ebs.myservice;


import com.zee.ebs.annotations.ZeeComponent;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Scope;

import java.math.BigDecimal;

import static org.springframework.beans.factory.config.BeanDefinition.SCOPE_PROTOTYPE;


/**
 * @dev : Ezekiel Eromosei
 * @date : 03 May, 2026
 */

@Slf4j
@ZeeComponent
@Scope(SCOPE_PROTOTYPE)
public class MonetaryService {

    public MonetaryService() {
        log.info("MonetaryService init...");
    }

    @PostConstruct
    public void init() {
        log.info("doing some startup work");
    }

    public BigDecimal doComplexStuff(){
        log.info("Doing some complex Monetary Stuff ...");

        try {
            Thread.sleep(10);
            log.info("Calling foreign exchange service .....");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        return BigDecimal.ONE;
    }


    @PreDestroy
    public void destroy(){
        log.info("doing some shutdown work");
    }
}
