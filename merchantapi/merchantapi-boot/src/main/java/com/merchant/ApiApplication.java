package com.merchant;

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
public class ApiApplication {

    public static void main(String[] args) {
        try {
            Properties properties = new Properties();
            properties.load(ApiApplication.class.getResourceAsStream("/system.properties"));

            SpringApplication app = new SpringApplication(ApiApplication.class);
            app.setDefaultProperties(properties);
            app.run(args);
            System.out.println("success");
            log.info("start ApiApplication success...");
        } catch (IOException e) {
            System.out.println("Fail to start ApiApplication due to exception:" + e.toString());
            log.error("Fail to start ApiApplication...", e);
        }
    }

}
