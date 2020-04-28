package com.spring.mq.activemq.queue.controller;

import com.spring.mq.activemq.queue.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.jms.Queue;
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
    Queue queue;

    // 发送队列消息
    @GetMapping("/queue")
    public String sendQueue() {
        Message message = new Message();
        message.setId((int) (System.currentTimeMillis() / 1000));
        message.setContent("Test queue message");
        message.setSendDate(new Date());
        jmsMessagingTemplate.convertAndSend(this.queue, message);
        return "发送成功";
    }
}
