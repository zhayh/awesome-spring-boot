package com.spring.mq.activemq;

import com.spring.mq.activemq.message.producer.Demo01Producer;
import com.spring.mq.activemq.model.Message;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.concurrent.ListenableFutureCallback;

import java.util.Date;
import java.util.concurrent.CountDownLatch;
import java.util.stream.IntStream;

@Slf4j
@SpringBootTest
class ActivemqDemoApplicationTests {
    @Autowired
    private Demo01Producer demo01Producer;

    @Test
    void contextLoads() {
    }

    @Test
    public void sendQueueMsg() {
        Message message = new Message();
        message.setContent("Test queue message");
        message.setSendDate(new Date());
        this.demo01Producer.sendQueue(message);
    }

    @Test
    public void send50QueueMsg() {
        IntStream.range(1, 50).forEach(
                i -> {
                    Message message = new Message();
                    message.setContent("Test queue message " + i);
                    message.setSendDate(new Date());
                    this.demo01Producer.sendQueue(message);
                });
    }

    @Test
    public void sendSimpleTopicMessage() {
        Message message = new Message();
        message.setContent("Test topic message");
        message.setSendDate(new Date());
        this.demo01Producer.sendTopic(message);
    }

    // 发送异步消息
    @Test
    public void testAsyncSend() throws InterruptedException {
        int id = (int) (System.currentTimeMillis() / 1000);
        Message message = new Message();
        message.setId(id);
        message.setContent("Test queue message");
        message.setSendDate(new Date());
        demo01Producer.asyncSend(message).addCallback(new ListenableFutureCallback<Void>() {
            @Override
            public void onFailure(Throwable e) {
                log.info("Test ASyncSend 发送编号： {} 发送异常{}", id, e);
            }
            @Override
            public void onSuccess(Void aVoid) {
                log.info("Test ASyncSend 发送： 编号{} 发送成功", id);
            }
        });
        log.info("Test ASyncSend 发送： 编号{} 调用完成", id);
    }
}
