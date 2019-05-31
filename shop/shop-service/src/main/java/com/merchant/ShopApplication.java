package com.merchant;

import lombok.extern.log4j.Log4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import java.io.IOException;
import java.util.Properties;

/**
 * Description:shop 启动类
 *
 * @author wangyf
 * @date 2019/4/16
 */
@Log4j
@SpringBootApplication
@EnableEurekaClient
public class ShopApplication {

    public static void main(String[] args) {
        try {
            Properties properties = new Properties();
            properties.load(ShopApplication.class.getResourceAsStream("/system.properties"));

            SpringApplication app = new SpringApplication(ShopApplication.class);
            app.setDefaultProperties(properties);
            app.run(args);
            System.out.println("success");
            log.info("shopApplication start success ...");
        } catch (IOException e) {
            System.out.println("Fail to start ShopApplication due to exception:" + e.toString());
        }
    }

}
