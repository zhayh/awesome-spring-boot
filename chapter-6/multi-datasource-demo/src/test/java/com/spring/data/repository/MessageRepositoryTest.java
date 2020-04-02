package com.spring.data.repository;

import com.spring.data.model.Message;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author : zhayh
 * @date : 2020-3-29 19:56
 * @description :
 */
@Slf4j
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class MessageRepositoryTest {
    @Autowired
    private MessageRepository messageRepository;
    @Autowired
    private JdbcTemplate primaryJdbcTemplate;
    @Autowired
    private JdbcTemplate secondaryJdbcTemplate;

    @Test
    @Order(1)
    public void testSave() {
        Message message = Message.builder().text("apple").summary("水果").build();
        messageRepository.save(message, primaryJdbcTemplate);
        messageRepository.save(message, secondaryJdbcTemplate);
    }

    @Test
    @Order(2)
    public void testBatchInsert() {
        List<Message> messages = new ArrayList<>(Arrays.asList(
                Message.builder().text("niit").summary("学校").build(),
                Message.builder().text("computer").summary("院系").build()));
        Arrays.stream(messageRepository.batchInsert(messages, primaryJdbcTemplate))
            .forEach(System.out::println);
    }

    @Test
    @Order(3)
    public void testFindAll() {
        messageRepository.findAll(primaryJdbcTemplate).forEach(
                message -> log.info(message.toString()));
    }
}
