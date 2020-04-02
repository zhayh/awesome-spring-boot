package com.spring.data.mysql.repository;

import com.spring.data.mysql.model.Message;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


/**
 * @author : zhayh
 * @date : 2020-4-1 20:02
 * @description :
 */
@Slf4j
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest
public class MessageRepositoryTest {
    @Autowired
    private MessageRepository messageRepository;

    @Test
    @Order(1)
    public void testInsert() {
        Message message = Message.builder().text("apple").summary("水果").build();
        messageRepository.insert(message);
    }

    @Test
    @Order(2)
    public void testFindAll() {
        messageRepository.findAll().forEach(message -> log.info(message.toString()));
    }
}
