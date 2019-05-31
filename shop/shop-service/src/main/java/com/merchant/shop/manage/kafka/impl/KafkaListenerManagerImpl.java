package com.merchant.shop.manage.kafka.impl;

import com.alibaba.fastjson.JSON;
import com.merchant.data.KafkaMessageConstant;
import com.merchant.shop.bo.shopuser.request.ShopUserBORequest;
import com.merchant.shop.manage.kafka.KafkaListenerManager;
import com.merchant.task.bean.Shop;
import com.merchant.task.bean.ShopUpdate;
import com.merchant.task.constant.TaskKafkaConstant;
import com.merchant.task.message.MessageTask;
import lombok.extern.log4j.Log4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
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
@Log4j
@Component("kafkaListenerManagerImpl")
public class KafkaListenerManagerImpl implements KafkaListenerManager {


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
    public String shopInsertToJson(ShopUserBORequest shopUserBORequest) {

        Shop shop = new Shop();
        shop.setShopAddress(shopUserBORequest.getShopAddress());
        shop.setShopCode(shopUserBORequest.getShopCode());
        shop.setShopContact(shopUserBORequest.getShopContact());
        shop.setShopName(shopUserBORequest.getShopName());
        shop.setShopPhone(shopUserBORequest.getShopPhone());
        shop.setTotalCommodityId(shopUserBORequest.getTotalCommodityId());
        shop.setUserId(shopUserBORequest.getUserId());
        List<Shop> shops = new ArrayList<>();
        shops.add(shop);
        MessageTask messageTask = new MessageTask();
        messageTask.setType(TaskKafkaConstant.Type.SHOP_INSERT);
        messageTask.setMsg(JSON.toJSONString(shops));

        return JSON.toJSONString(messageTask);
    }

    @Override
    public String shopUpdateToJson(ShopUserBORequest shopUserBORequest) {
        ShopUpdate shop = new ShopUpdate();
        shop.setShopAddress(shopUserBORequest.getShopAddress());
        shop.setShopCode(shopUserBORequest.getShopCode());
        shop.setShopContact(shopUserBORequest.getShopContact());
        shop.setShopName(shopUserBORequest.getShopName());
        shop.setShopPhone(shopUserBORequest.getShopPhone());
        shop.setTotalCommodityId(shopUserBORequest.getTotalCommodityId());
        shop.setUserId(shopUserBORequest.getUserId());
        shop.setId(1);
        List<ShopUpdate> shops = new ArrayList<>();
        shops.add(shop);
        MessageTask messageTask = new MessageTask();
        messageTask.setType(TaskKafkaConstant.Type.SHOP_UPDATE);
        messageTask.setMsg(JSON.toJSONString(shops));

        return JSON.toJSONString(messageTask);
    }
}
