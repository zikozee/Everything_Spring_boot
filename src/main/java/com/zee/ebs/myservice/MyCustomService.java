package com.zee.ebs.myservice;


import com.zee.ebs.EbsApplication;
import com.zee.ebs.annotations.ZeeComponent;
import jakarta.annotation.PreDestroy;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;

/**
 * @dev : Ezekiel Eromosei
 * @date : 24 Apr, 2026
 */

@Slf4j
@ZeeComponent
@RequiredArgsConstructor
public class MyCustomService implements CommandLineRunner {

    private final MonetaryService monetaryService;

    @Override
    public void run(String... args) throws Exception {
        log.info("========>>>>>>>>>Zee Component:: MyCustomService is running...");
        doSomeWork();

        System.out.println("\n========>=============================================\n");

        ApplicationContext context = EbsApplication.getContext();
        MonetaryService monetaryBean = context.getBean(MonetaryService.class);
        monetaryBean.doComplexStuff();
        monetaryBean.doComplexStuff();
//        monetaryBean.doComplexStuff();

    }

    // GlobalExceptionHandler  --->  @RestControllerAdvice
    public static void doSomeWork(){
        ApplicationContext context = EbsApplication.getContext();
        ComponentService bean = context.getBean(ComponentService.class);
        String s = bean.checkMe();
        log.info("Currently in MyCustomerService {}", s.contains("WOOOO!!!"));
    }

    @PreDestroy
    public void destroy(){
        log.info("doing some shutdown work for MyCustomService");
    }
}
