package com.merchant.user.manage.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.merchant.task.bean.User;
import com.merchant.task.bean.UserUpdate;
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
import java.util.ArrayList;
import java.util.List;

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
    public String dealInsertBeanToJson(UserBORequest userBORequest) {

        /**
         * 根据需求  组装相对应的消息
         */

        MessageTask messageTask=new MessageTask();
        messageTask.setType(TaskKafkaConstant.Type.USER_INSERT);

        User user=new User();
        user.setPassWord(userBORequest.getPassWord());
        user.setPhone(userBORequest.getPhone());
        user.setType(userBORequest.getType());
        user.setUserName(userBORequest.getUserName());


        List<User> users=new ArrayList<>();
        users.add(user);
        messageTask.setMsg(JSON.toJSONString(users));
        return JSONObject.toJSONString(messageTask);

    }

    @Override
    public String dealUpdateBeanToJson(UserBORequest userBORequest) {
        /**
         * 根据需求  组装相对应的消息
         */

        MessageTask messageTask=new MessageTask();
        messageTask.setType(TaskKafkaConstant.Type.USER_UPDATE);

        UserUpdate user=new UserUpdate();
        user.setId(1);
        user.setPassWord(userBORequest.getPassWord());
        user.setPhone(userBORequest.getPhone());
        user.setType(userBORequest.getType());
        user.setUserName(userBORequest.getUserName());


        List<UserUpdate> users=new ArrayList<>();
        users.add(user);
        messageTask.setMsg(JSON.toJSONString(users));
        return JSONObject.toJSONString(messageTask);
    }
}
