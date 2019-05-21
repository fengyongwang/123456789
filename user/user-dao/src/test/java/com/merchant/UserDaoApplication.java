package com.merchant;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Properties;

/**
 * Description:
 *
 * @author wangyf
 * @date 2019/5/5
 */
@SpringBootApplication
@MapperScan("com.merchant.user.mapper")
public class UserDaoApplication {


    public static void main(String[] args) {
        try {
            Properties properties = new Properties();
            SpringApplication app = new SpringApplication(UserDaoApplication.class);
            app.setDefaultProperties(properties);
            app.run(args);
            System.out.println("success");
        } catch (Exception e) {
            System.out.println("Fail to start UserDaoApplication due to exception:" + e.toString());
        }
    }
}
