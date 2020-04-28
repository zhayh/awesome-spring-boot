package com.spring.mq.activemq.topic;

import com.spring.mq.activemq.topic.message.producer.Demo01Producer;
import com.spring.mq.activemq.topic.model.Message;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.concurrent.ListenableFutureCallback;

import java.util.Date;
import java.util.stream.IntStream;

@Slf4j
@SpringBootTest
class ActivemqTopicDemoApplicationTests {
    @Autowired
    private Demo01Producer demo01Producer;

    @Test
    void contextLoads() {
    }

    @Test
    public void sendSimpleTopicMessage() {
        Message message = new Message();
        message.setContent("Test topic message");
        message.setSendDate(new Date());
        this.demo01Producer.sendTopic(message);
    }
}
