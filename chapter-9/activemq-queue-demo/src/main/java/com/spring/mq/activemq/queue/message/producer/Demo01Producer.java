package com.spring.mq.activemq.queue.message.producer;

import com.spring.mq.activemq.queue.model.Message;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;

import javax.jms.Queue;

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
    Queue queue;

    // 发送同步队列消息
    public void sendQueue(Message message) {
        log.info("send queue msg: {}", message);
        jmsMessagingTemplate.convertAndSend(this.queue, message);
    }

    // 发送异步队列消息
    @Async
    public ListenableFuture<Void> asyncSend(Message message) {
        try {
            // 发送消息
            this.sendQueue(message);
            // 返回成功的 Future
            return AsyncResult.forValue(null);
        } catch (Throwable ex) {
            // 返回异常的 Future
            return AsyncResult.forExecutionException(ex);
        }
    }
}
