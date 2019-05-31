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
 * @date 2019/5/30
 */
@Component("userInsertRunnerImpl")
@Log4j
public class UserInsertRunnerImpl implements TaskRunner {

    String type = TaskKafkaConstant.Type.USER_INSERT;

    Class itemClass = TaskKafkaConstant.ClassMap.INSERT_USER;

    @Override
    public void exec(List<Object> obj) {

        /**
         * user 添加过来的 得逻辑
         */
        log.info("user 添加过来的 得逻辑 ...");

    }

    @Override
    public List<Object> parseObject(String jsonString) {
        return JSON.parseArray(jsonString, itemClass);
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
