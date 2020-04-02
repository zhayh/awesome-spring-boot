package com.spring.data.druid.repository;

import com.spring.data.druid.exception.CustomDuplicatedKeyException;
import com.spring.data.druid.model.Message;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
        Message message = Message.builder().msgText("apple").msgSummary("水果").build();
        log.info(String.valueOf(messageRepository.insert(message)));
    }

    @Test
    @Order(2)
    public void testBatchInsert() {
        List<Message> messages = new ArrayList<>(Arrays.asList(
                Message.builder().msgText("niit").msgSummary("学校").build(),
                Message.builder().msgText("computer").msgSummary("院系").build()));
        Arrays.stream(messageRepository.batchInsert(messages))
                .forEach(System.out::println);
    }

    @Test
    @Order(3)
    public void testFindAll() {
        messageRepository.findAll().forEach(message -> log.info(message.toString()));
    }

    // 事务管理的测试
    @Autowired
    private TransactionTemplate transactionTemplate;

    @Test
    public void testTransaction() {
        log.info("事务前的记录数： {}", messageRepository.count());
        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
                Message msg = Message.builder().msgText("事务管理").msgSummary("事务").build();
                messageRepository.insert(msg);
                log.info("事务中的记录数： {}", messageRepository.count());
                transactionStatus.setRollbackOnly();
            }
        });
        log.info("事务后的记录数： {}", messageRepository.count());
    }

    // 自定义异常码测试
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    public void testThrowingCustomException() {
        Assertions.assertThrows(CustomDuplicatedKeyException.class, () -> {
            jdbcTemplate.execute("INSERT INTO message (msg_id, msg_text, msg_summary) VALUES (1, 'a', 'b')");
            jdbcTemplate.execute("INSERT INTO message (msg_id, msg_text, msg_summary) VALUES (1, 'c', 'd')");
        });
    }
}
