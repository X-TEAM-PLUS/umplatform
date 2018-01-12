package com.platform.admin.webapp;


import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Created by xinleisong on 2017/2/21.
 */
@EnableDiscoveryClient // Eureka Discovery Client 标识
@EnableFeignClients(basePackages = {"com.platform.admin.api"})
@ServletComponentScan("com.platform.admin.security")
@SpringBootApplication(scanBasePackages = {"com.platform.admin"}) // Spring Boot 应用标识
public class ApplicationBoot {

    private static Logger logger = Logger.getLogger(ApplicationBoot.class);

    /**
     * Main Start
     */
    public static void main(String[] args) {
        SpringApplication.run(ApplicationBoot.class, args);
        logger.info("============= SpringBoot Start Success ============= ");
    }

}
