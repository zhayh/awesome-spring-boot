package com.spring.mq.activemq.controller;

import com.spring.mq.activemq.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.jms.Queue;
import javax.jms.Topic;

/**
 * @author : zhayh
 * @date : 2020-4-24 15:41
 * @description :
 */

@RestController
public class ProducerController {
    @Autowired
    JmsMessagingTemplate jmsMessagingTemplate;
    @Autowired
    Queue queue;
    @Autowired
    Topic topic;

    // 发送队列消息
    @GetMapping("/sendQueue")
    public void sendQueue(Message message) {
        jmsMessagingTemplate.convertAndSend(this.queue, message);
    }

    // 发送订阅消息
    @GetMapping("/sendTopic")
    public void sendTopic(Message message) {
        jmsMessagingTemplate.convertAndSend(this.topic, message);
    }
}
