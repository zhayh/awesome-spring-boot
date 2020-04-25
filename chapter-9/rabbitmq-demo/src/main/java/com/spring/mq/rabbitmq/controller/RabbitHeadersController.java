package com.spring.mq.rabbitmq.controller;

import com.spring.mq.rabbitmq.model.HeaderMessage;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @author : zhayh
 * @date : 2020-4-25 13:49
 * @description :
 * request url: http://localhost:8080/rabbitmq/header/producer?exchangeName=header-exchange&department=admin&messageData=HelloAdminHeader
 */

@RestController
@RequestMapping(value="/rabbitmq/header/")
public class RabbitHeadersController {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @GetMapping("/producer")
    public String producer(@RequestParam("exchangeName") String exchange,
                           @RequestParam("department") String department,
                           @RequestParam("messageData") String messageData) {
        MessageProperties messageProperties = new MessageProperties();
        messageProperties.setHeader("department", department);

        HeaderMessage headersMessage = new HeaderMessage();
        headersMessage.setId((int) (System.currentTimeMillis() / 1000));
        headersMessage.setContent("Headers Exchange Message");
        headersMessage.setCreateDate(new Date());

        Message message = rabbitTemplate.getMessageConverter().toMessage(headersMessage, messageProperties);
        rabbitTemplate.convertAndSend(exchange, "", message);
        return "Header Exchange 消息发送成功";
    }
}

