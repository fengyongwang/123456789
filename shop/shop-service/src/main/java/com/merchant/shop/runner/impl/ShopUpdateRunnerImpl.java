package com.merchant.shop.runner.impl;

import com.alibaba.fastjson.JSON;
import com.merchant.shop.runner.TaskRunner;
import com.merchant.task.constant.TaskKafkaConstant;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Description:
 *
 * @author wangyf
 * @date 2019/5/31
 */
@Log4j
@Component("shopUpdateRunnerImpl")
public class ShopUpdateRunnerImpl implements TaskRunner {

    String type= TaskKafkaConstant.Type.SHOP_UPDATE;

    Class itemClass= TaskKafkaConstant.ClassMap.UPDATE_SHOP;


    @Override
    public void exec(List<Object> obj) {

        /**
         * 商铺update 过来的逻辑
         */

        log.info("商铺update 过来的逻辑");

    }

    @Override
    public List<Object> parseObject(String jsonString) {
        return JSON.parseArray(jsonString,itemClass);
    }

    @Override
    public String getType() {
        return this.type;
    }

    @Override
    public boolean equalsType(String type) {
        return this.type.equals(type);
    }
}
