package com.hitices.environment_statistics;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author ferdinandsu
 * @date 2021/8/18
 **/

@EnableEurekaClient
@SpringBootApplication//(exclude= {DataSourceAutoConfiguration.class})
public class ApplicationMain {
    public static void main(String[] args) {
        SpringApplication.run(ApplicationMain.class, args);
    }
}
