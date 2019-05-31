package com.merchant.shop.listener.impl;

import com.alibaba.fastjson.JSON;
import com.merchant.shop.listener.KafkaTaskListener;
import com.merchant.shop.manage.shopuser.MessageDistributionManage;
import com.merchant.task.constant.TaskKafkaConstant;
import com.merchant.task.message.MessageTask;
import lombok.extern.log4j.Log4j;
import org.apache.commons.lang.StringUtils;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * Description:
 *
 * @author wangyf
 * @date 2019/5/30
 */
@Log4j
@Component("kafkaListenerImpl")
public class KafkaTaskListenerImpl implements KafkaTaskListener {

    @Resource(name = "messageDistributionManageImpl")
    private MessageDistributionManage messageDistributionManage;


    @Override
    @KafkaListener(topics = {TaskKafkaConstant.Topic.TASK_TOPIC})
    public void receive(ConsumerRecord<?, ?> record) {

        String message = (String) record.value();

        if (StringUtils.isBlank(message)) {
            log.error("receive message from kafka error ...");
            return ;
        }

        log.info("receive message from kafka is : "+message.toString());

        /**
         * json 数据转换为相应得javaBean
         */
        MessageTask messageTask= JSON.parseObject(message,MessageTask.class);

        this.messageDistributionManage.distribut(messageTask);

    }
}
