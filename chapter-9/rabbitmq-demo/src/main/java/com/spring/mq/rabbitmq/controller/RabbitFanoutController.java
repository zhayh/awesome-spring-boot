package com.spring.mq.rabbitmq.controller;

import com.spring.mq.rabbitmq.model.Message;
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
 * request url : http://localhost:8080/rabbitmq/fanout/producer?exchangeName=fanout-exchange&messageData=HelloFanout
 */

@RestController
@RequestMapping(value="/rabbitmq/fanout/")
public class RabbitFanoutController {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @GetMapping("/producer")
    public String producer(@RequestParam("exchangeName") String exchange,
                           @RequestParam("messageData") String messageData) {
        Message message = new Message();
        message.setId((int) (System.currentTimeMillis() / 1000));
        message.setContent(messageData);
        message.setCreateDate(new Date());
        rabbitTemplate.convertAndSend(exchange, "", message);
        return "Fanout Exchange 消息发送成功";
    }
}
