package com.spring.data.repository;

import com.spring.data.model.Message;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * @author : zhayh
 * @date : 2020-3-29 19:56
 * @description :
 */

@SpringBootTest
public class MessageRepositoryTest {
    @Autowired
    private MessageRepository messageRepository;
    @Autowired
    private JdbcTemplate primaryJdbcTemplate;
    @Autowired
    private JdbcTemplate secondaryJdbcTemplate;

    @Test
    public void testSave() {
        Message message = Message.builder().content("apple").summary("水果").build();
        messageRepository.save(message, primaryJdbcTemplate);
        messageRepository.save(message, secondaryJdbcTemplate);
    }
}
