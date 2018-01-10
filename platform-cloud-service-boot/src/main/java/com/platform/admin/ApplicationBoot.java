package com.platform.admin;

import org.apache.log4j.Logger;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Created by xinleisong on 2017/2/21.
*/
@MapperScan("com.platform.admin.dao")
@SpringBootApplication(scanBasePackages = {"com.platform.admin"})
//启注解事务管理
@EnableTransactionManagement
@EnableDiscoveryClient
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
