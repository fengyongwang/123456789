package com.customer.config;

import com.merchant.convert.ConvertManager;
import com.merchant.convert.impl.ConvertManagerImpl;
import org.dozer.DozerBeanMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

/**
 * Description:
 *
 * @author wangyf
 * @date 2019/4/30
 */
@Configuration
public class ConvertConfig {

    /**
     * ConvertManager  的bean
     * @return
     */
    @Bean
    public  ConvertManager convertManager(){
        return  new ConvertManagerImpl();
    }


    /**
     * dozer的bean
     */
    @Bean
    public DozerBeanMapper dozerBeanMapper() {
        DozerBeanMapper mapper = new DozerBeanMapper();
        List<String> fileNameList = new ArrayList<>();
//        fileNameList.add("dozer/mapping-result.xml");
        mapper.setMappingFiles(fileNameList);
        return mapper;
    }



}
