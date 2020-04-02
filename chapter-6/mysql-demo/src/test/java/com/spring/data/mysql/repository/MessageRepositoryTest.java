package com.spring.data.mysql.repository;

import com.spring.data.mysql.model.Message;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author : zhayh
 * @date : 2020-4-2 08:45
 * @description :
 */

@Slf4j
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class MessageRepositoryTest {
    @Autowired
    private MessageRepository messageRepository;

    @Test
    @Order(1)
    public void testInsert() {
        Message message = Message.builder().msgText("niit").msgSummary("学校").build();
        int num = messageRepository.insert(message);
        log.info("插入的数据条数： {}", num);
    }

    @Test
    @Order(2)
    public void testBatchInsert() {
        List<Message> messages = new ArrayList<>(Arrays.asList(
                Message.builder().msgText("apple").msgSummary("水果").build(),
                Message.builder().msgText("orange").msgSummary("水果").build()));
        Arrays.stream(messageRepository.batchInsert(messages))
                .forEach(System.out::println);
    }

    @Test
    @Order(3)
    public void testFindAll() {
        messageRepository.findAll().forEach(
                message -> log.info("查询的数据： {}", message.toString()));
    }

    @Test
    @Order(4)
    public void testUpdate() {
        Message message = Message.builder().msgId(1).msgText("computer").msgSummary("学校").build();
        int num = messageRepository.update(message);
        log.info("更新的数据条数： {}", num);
    }
    @Test
    @Order(5)
    public void testUpdateText() {
        Message message = Message.builder().msgId(2).msgText("computer").msgSummary("学校").build();
        int num = messageRepository.updateText(message);
        log.info("更新Text的数据条数： {}", num);
    }

    @Test
    @Order(6)
    public void testFindById() {
        Message message = messageRepository.findById(1);
        log.info("id为1的数据： {}", message);
    }

    @Test
    @Order(7)
    public void testDelete() {
        int num = messageRepository.delete(1);
        log.info("删除的数据条数： {}", num);
    }
}
