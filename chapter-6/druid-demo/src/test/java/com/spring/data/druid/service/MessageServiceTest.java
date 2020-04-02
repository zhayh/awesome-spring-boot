package com.spring.data.druid.service;

import com.spring.data.druid.exception.RollbackException;
import com.spring.data.druid.model.Message;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.AdviceMode;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author : zhayh
 * @date : 2020-4-1 22:41
 * @description :
 */

@Slf4j
@SpringBootTest
@EnableTransactionManagement(mode = AdviceMode.PROXY)
public class MessageServiceTest {
    @Autowired
    private MessageService messageService;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    public void testTransaction() {
        Message message = Message.builder().msgText("niit").msgSummary("学校").build();
        messageService.insertRecord(message);
        log.info("niit {}", jdbcTemplate.queryForObject(
                "SELECT Count(*) FROM Message WHERE text='niit'", Long.class));

        message = Message.builder().msgText("apple").msgSummary("水果").build();
        try {
            messageService.insertThenRollback(message);
        } catch (RollbackException e) {
            log.info("apple {}", jdbcTemplate.queryForObject(
                    "SELECT Count(*) FROM Message WHERE text='apple'", Long.class));
        }

        message = Message.builder().msgText("orange").msgSummary("水果").build();
        try {
            messageService.invokeInsertThenRollback(message);
        } catch (RollbackException e) {
            log.info("orange {}", jdbcTemplate.queryForObject(
                    "SELECT Count(*) FROM Message WHERE text='orange'", Long.class));
        }
    }
}
