package com.merchant.shop.manage.shopuser.impl;


import com.merchant.shop.factory.RunnnerFactory;
import com.merchant.shop.manage.shopuser.MessageDistributionManage;
import com.merchant.shop.runner.TaskRunner;
import com.merchant.task.message.MessageTask;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.List;

/**
 * Description:
 *
 * @author wangyf
 * @date 2019/5/30
 */
@Log4j
@Component("messageDistributionManageImpl")
public class MessageDistributionManageImpl implements MessageDistributionManage {


    @Resource
    private RunnnerFactory runnnerFactory;


    @Override
    public void distribut(MessageTask messageTask) {

        List<TaskRunner> taskRunners= this.runnnerFactory.getRunners(messageTask.getType());

        if(CollectionUtils.isEmpty(taskRunners)){
            log.error("runners empty by type ...");
            return ;
        }
        this.runnersExec(taskRunners,messageTask);
    }


    private void runnersExec(List<TaskRunner>runners,MessageTask messageTask){

        for (TaskRunner runner:runners) {
            if(runner.equalsType(messageTask.getType())){
                runner.exec(runner.parseObject(messageTask.getMsg()));
            }
        }

    }

}
