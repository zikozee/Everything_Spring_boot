package com.zee.ebs.conditionals;


import com.zee.ebs.conditionals.cache.CustomCache1;
import com.zee.ebs.conditionals.cache.CustomCache2;
import com.zee.ebs.conditionals.cache.DefaultCache;
import com.zee.ebs.conditionals.factory.ConnectionFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

/**
 * @dev : Ezekiel Eromosei
 * @date : 08 Jun, 2026
 */

@Configuration
@ConditionalOnClass(name = "com.zee.ebs.conditionals.MacCondition")
public class AppConfig {

    @Bean
    @Conditional(LinuxCondition.class)
    public String linuxBean(){
        return "Running on Linux";
    }

    @Bean
    @Conditional(MacCondition.class)
    public String macBean(){
        System.out.println("Hey Running on Mac");
        return "Running on Mac";
    }

    @Bean
    @ConditionalOnProperty(name = "feature.payment.enabled", havingValue = "true")
    String paymentServiceBean() {
        System.out.println("Payment Service Booming!!!");
        return "Running Payment Service";
    }

    @Bean
    @ConditionalOnProperty(name = "is.redis.Cluster", havingValue = "true")
    ConnectionFactory redisClusterBean() {
        System.out.println("Redis Sentinel");
        return new ConnectionFactory("Sentinel");
    }

    @Bean
    @ConditionalOnProperty(name = "is.redis.Cluster", havingValue = "false")
    ConnectionFactory redisStandaloneBean() {
        System.out.println("Redis Standalone");
        return new ConnectionFactory("Standalone");
    }

    @Bean
    DefaultCache defaultCache() {
        return new DefaultCache();
    }

    @Bean
    @ConditionalOnMissingBean(DefaultCache.class)
    CustomCache1 customCache1() {
        System.out.println("Custom Cache 1");
        return new CustomCache1();
    }

    @Bean
    @ConditionalOnBean(DefaultCache.class)
    CustomCache2 customCache2() {
        System.out.println("Custom Cache 2");
        return new CustomCache2();
    }

    @Bean
    @ConditionalOnClass(name = "com.zee.ebs.conditionals.LinuxConditiodsdssn")
    String testingConditionalOnClass() {
        System.out.println("class Linux available");
        return "class Linux available";
    }
}
