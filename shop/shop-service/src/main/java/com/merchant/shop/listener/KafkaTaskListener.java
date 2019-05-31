package com.merchant.shop.listener;

import org.apache.kafka.clients.consumer.ConsumerRecord;

/**
 * Description:
 *
 * @author wangyf
 * @date 2019/5/30
 */
public interface KafkaTaskListener {

    void receive(ConsumerRecord<?, ?> record);

}
