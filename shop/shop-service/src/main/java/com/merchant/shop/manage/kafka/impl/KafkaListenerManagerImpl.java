package com.merchant.shop.manage.kafka.impl;

import com.merchant.data.KafkaMessageConstant;
import com.merchant.shop.manage.kafka.KafkaListenerManager;
import lombok.extern.log4j.Log4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * Description:
 *
 * @author wangyf
 * @date 2019/5/22
 */
@Log4j
@Component("kafkaListenerManagerImpl")
public class KafkaListenerManagerImpl implements KafkaListenerManager {
    @Override
    @KafkaListener(topics ={KafkaMessageConstant.DEMO_KAFKA_TEST} )
    public void receive(ConsumerRecord<?, ?> consumer) {
       String str= (String)consumer.value();
       log.info("接受来的消息:"+str);
    }
}
