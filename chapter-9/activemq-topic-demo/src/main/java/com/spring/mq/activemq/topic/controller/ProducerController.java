package com.spring.mq.activemq.topic.controller;

import com.spring.mq.activemq.topic.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.jms.Queue;
import javax.jms.Topic;
import java.util.Date;

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
    Topic topic;

    // 发送订阅消息
    @GetMapping("/topic")
    public String sendTopic() {
        Message message = new Message();
        message.setId((int) (System.currentTimeMillis() / 1000));
        message.setContent("Test queue message");
        message.setSendDate(new Date());
        jmsMessagingTemplate.convertAndSend(this.topic, message);
        return "发送成功";
    }
}
