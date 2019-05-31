package com.merchant.user.manage.impl;

import com.alibaba.fastjson.JSONObject;
import com.merchant.task.constant.TaskKafkaConstant;
import com.merchant.task.message.MessageTask;
import com.merchant.user.bo.user.request.UserBORequest;
import com.merchant.user.manage.MessageManagerDemo;
import lombok.extern.log4j.Log4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import javax.annotation.Resource;

/**
 * Description:
 *
 * @author wangyf
 * @date 2019/5/22
 */
@Component
@Log4j
public class MessageManagerDemoImpl implements MessageManagerDemo {


    @Resource
    private KafkaTemplate<String, String> kafkaTemplate;

    @Override
    public void sendMessage(String message) {
        ListenableFuture<SendResult<String, String>> future = kafkaTemplate.send(TaskKafkaConstant.Topic.TASK_TOPIC, message);
        future.addCallback(new ListenableFutureCallback<SendResult<String, String>>() {
            @Override
            public void onFailure(Throwable ex) {
                log.error("send message error ...", ex);
            }

            @Override
            public void onSuccess(SendResult<String, String> result) {
                log.info("send message success ...");
            }
        });
    }

    @Override
    public String dealBeanToJson(UserBORequest userBORequest) {

        MessageTask messageTask=new MessageTask();
        messageTask.setType(TaskKafkaConstant.Type.USER_INSERT);

        return JSONObject.toJSONString(userBORequest);

    }
}
