package com.merchant.shop.factory.impl;


import com.merchant.shop.factory.RunnnerFactory;
import com.merchant.shop.runner.TaskRunner;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * Description:
 *
 * @author wangyf
 * @date 2019/5/30
 */
@Component
@Log4j
public class RunnerFactoryImpl implements RunnnerFactory, ApplicationContextAware {

    private volatile ApplicationContext applicationContext;

    /**
     * 所有得需要执行得任务集合
     */
    private Map<String, List<TaskRunner>> runnerMap;

    @Override
    public List<TaskRunner> getRunners(String type) {
        if (this.runnerMap == null || this.runnerMap.isEmpty()) {
            this.init();
        }
        return runnerMap.get(type);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {

        this.applicationContext = applicationContext;
    }


    private void init(){

        /**
         * key 为type value 为list得所有执行任务得集合
         */
        Map<String,List<TaskRunner>>typeRunnerMap=new HashMap<>();


       Map<String,TaskRunner>taskRunnerMap= applicationContext.getBeansOfType(TaskRunner.class);

        Collection<TaskRunner> runners= taskRunnerMap.values();

        for (TaskRunner runner:runners) {

            List<TaskRunner> taskRunners= typeRunnerMap.get(runner.getType());
            if(taskRunners==null||taskRunners.isEmpty()){
                taskRunners=new ArrayList<>();
            }
            taskRunners.add(runner);
            typeRunnerMap.put(runner.getType(),taskRunners);

        }

        this.runnerMap=typeRunnerMap;

    }

}
