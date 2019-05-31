package com.merchant.shop.runner.impl;

import com.alibaba.fastjson.JSON;
import com.merchant.shop.runner.TaskRunner;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Description:
 *
 * @author wangyf
 * @date 2019/5/30
 */
@Component("taskRunnerImpl")
@Log4j
public class TaskRunnerImpl implements TaskRunner {

    String type="default";

    Class itemClass=Object.class;

    @Override
    public void exec(List<Object> obj) {

        /**
         * 每个任务执行 得逻辑
         */

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
