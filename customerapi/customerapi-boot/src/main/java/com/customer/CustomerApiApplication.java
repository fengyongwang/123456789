package com.customer;

import lombok.extern.log4j.Log4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.io.IOException;
import java.util.Properties;

/**
 * Description:ZdApi 启动类
 *
 * @author wangyf
 * @date 2019/4/16
 */
@Log4j
@SpringBootApplication
@EnableEurekaClient
@EnableSwagger2
public class CustomerApiApplication {

    public static void main(String[] args) {
        try {
            Properties properties = new Properties();
            properties.load(CustomerApiApplication.class.getResourceAsStream("/system.properties"));

            SpringApplication app = new SpringApplication(CustomerApiApplication.class);
            app.setDefaultProperties(properties);
            app.run(args);
            System.out.println("success");
            log.info("start CustomerApiApplication success...");
        } catch (IOException e) {
            System.out.println("Fail to start CustomerApiApplication due to exception:" + e.toString());
            log.error("Fail to start CustomerApiApplication...", e);
        }
    }

}
