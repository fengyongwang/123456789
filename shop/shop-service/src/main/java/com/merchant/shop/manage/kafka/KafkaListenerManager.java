package com.merchant.shop.manage.kafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;

/**
 * Description:
 *
 * @author wangyf
 * @date 2019/5/22
 */
public interface KafkaListenerManager {

    /**
     * 接受kafka消息
     * @param consumer
     */
    void receive(ConsumerRecord<?, ?> consumer);

}
