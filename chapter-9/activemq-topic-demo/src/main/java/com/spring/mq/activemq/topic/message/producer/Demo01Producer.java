package com.spring.mq.activemq.topic.message.producer;

import com.spring.mq.activemq.topic.model.Message;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;

import javax.jms.Queue;
import javax.jms.Topic;

/**
 * @author : zhayh
 * @date : 2020-4-24 13:23
 * @description : 消息生产者
 */
@Slf4j
@Component
public class Demo01Producer {
    // Spring提供的发送消息的工具类
    @Autowired
    JmsMessagingTemplate jmsMessagingTemplate;
    @Autowired
    Topic topic;

    // 发送订阅消息
    public void sendTopic(Message message) {
        log.info("send topic msg: {}", message);
        jmsMessagingTemplate.convertAndSend(this.topic, message);
    }
}
