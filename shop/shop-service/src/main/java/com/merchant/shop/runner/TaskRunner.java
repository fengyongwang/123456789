package com.merchant.shop.runner;

import java.util.List;

/**
 * Description:
 *
 * @author wangyf
 * @date 2019/5/30
 */
public interface TaskRunner {




    /**
     * 每个runner 执行方法
     * @param obj
     */
    void exec(List<Object> obj);

    /**
     * 将json数据转为集合数据
     * @param jsonString
     * @return
     */
    List<Object>parseObject(String jsonString);


    String getType();


    boolean equalsType(String type);

}

