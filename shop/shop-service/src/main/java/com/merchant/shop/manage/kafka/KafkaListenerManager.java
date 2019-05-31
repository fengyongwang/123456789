package com.merchant.shop.manage.kafka;

import com.merchant.shop.bo.shopuser.request.ShopUserBORequest;
import org.apache.kafka.clients.consumer.ConsumerRecord;

/**
 * Description:
 *
 * @author wangyf
 * @date 2019/5/22
 */
public interface KafkaListenerManager {

    /**
     * 发送消息到kafka
     * @param message
     */
    void sendMessage(String message);

    /**
     * shop 添加 转为json
     * @param shopUserBORequest
     * @return
     */
    String shopInsertToJson(ShopUserBORequest shopUserBORequest);


    /**
     * 门店修改 转为json
     * @param shopUserBORequest
     * @return
     */
    String shopUpdateToJson(ShopUserBORequest shopUserBORequest);
}
