package com.merchant.shop.manage.shopuser;

import com.merchant.task.message.MessageTask;

/**
 * Description:
 *
 * @author wangyf
 * @date 2019/5/30
 */
public interface MessageDistributionManage {

    /**
     * 任务执行得总入口
     * @param messageTask
     */
    void distribut(MessageTask messageTask);

}
