package com.customer.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Description:
 *
 * @author wangyf
 * @date 2019/4/30
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {


    @Value("${auth.header.domain:1}")
    private String domain;



    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        /**
         *
         */
//        registry.addInterceptor(apiInterceptor).addPathPatterns(this.buildParam(
//                //的拦截路径
//                this.interceptorPath()))
//                .excludePathPatterns(this.buildParam(this.unInterceptorPath()));;

    }


    /**
     * 需要拦截的url
     *
     * @return 路径名称
     */
    private String[] interceptorPath() {
        return new String[]{"/merchant/**"};
    }


    /**
     * 不需要拦截的url
     *
     * @return 路径名称
     */
    private String[] unInterceptorPath() {

        return new String[]{"/merchant/user/get-sms-code", "/merchant/user/registered", "/merchant/user/login",
                "/merchant/user/retrieve-password","/merchant/region/query-area"};
    }

    /**
     * 解决跨域问题
     *
     * @param registry 注册信息
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**").allowedOrigins(domain).allowedMethods("GET", "POST", "OPTIONS", "DELETE", "PUT")
                .allowedHeaders("Content-Type", "X-Requested-With", "accept", "Origin", "Access-Control-Request-Method",
                        "Access-Control-Request-Headers")
                .exposedHeaders("Access-Control-Allow-Origin", "Access-Control-Allow-Credentials")
                .allowCredentials(true).maxAge(3600);

    }


    /**
     * 把多个数组再次合并为一个数组
     *
     * @param paths 拦截路径
     * @return 拦截路径的数组
     */
    private String[] buildParam(String[]... paths) {
        List<String> pathArr = new ArrayList<>();
        for (String[] path : paths) {
            pathArr.addAll(Arrays.asList(path));
        }
        return pathArr.toArray(new String[pathArr.size()]);
    }


}
