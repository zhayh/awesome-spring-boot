package com.spring.mq.activemq.topic.message.consumer;

import com.spring.mq.activemq.topic.model.Message;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * @author : zhayh
 * @date : 2020-4-24 13:23
 * @description : 消息消费者
 */
@Slf4j
@Component
public class Demo02Consumer {
    // 接收订阅消息
    @JmsListener(destination = "niit.topic")
    public void receiveTopic(Message message) {
        log.info("Consumer02接收到的订阅消息: {}", message);
    }
}
