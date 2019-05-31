package com.merchant.shop.factory;

import com.merchant.shop.runner.TaskRunner;

import java.util.List;

/**
 * Description:
 *
 * @author wangyf
 * @date 2019/5/30
 */
public interface RunnnerFactory {

    /**
     * 根据type 获取到所有得任务所需执行得runner
     * @param type
     * @return
     */
    List<TaskRunner> getRunners(String type);

}
