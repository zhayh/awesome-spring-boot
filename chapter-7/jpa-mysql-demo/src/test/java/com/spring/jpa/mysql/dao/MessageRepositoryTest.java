package com.spring.jpa.mysql.dao;

import com.spring.jpa.mysql.model.Message;
import com.spring.jpa.mysql.service.MessageService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * @author : zhayh
 * @date : 2020-4-9 22:01
 * @description :
 */

@Slf4j
@SpringBootTest
public class MessageRepositoryTest {
    @Autowired
    private MessageRepository messageRepository;

    @Test
    public void testSave() {
        Message message = Message.builder().msgText("computer").msgSummary("学习").build();
        // 保存单个对象
        messageRepository.save(message);

        List<Message> messages = new ArrayList<>(Arrays.asList(
                Message.builder().msgText("apple").msgSummary("水果").build(),
                Message.builder().msgText("orange").msgSummary("水果").build(),
                Message.builder().msgText("banana").msgSummary("水果").build()));
        // 保存多个
        messageRepository.saveAll(messages);
    }

    @Test
    public void testDelete() {
        Message message = Message.builder().msgId(1)
                .msgText("computer").msgSummary("学习").build();

        // 删除单条记录
        // 根据主键删除
        messageRepository.deleteById(1);
        // 提供对象，根据主键删除
        messageRepository.delete(message);

        // 删除集合
        message = Message.builder().msgId(2)
                .msgText("computer").msgSummary("学习").build();
        List<Message> messages = new ArrayList<>();
        messages.add(message);
        message = Message.builder().msgId(3)
                .msgText("computer").msgSummary("学习").build();
        messages.add(message);
        // 删除集合：一条一条删除
        messageRepository.deleteAll(messages);
        // 删除集合：一条 sql，拼接 or语句
        messageRepository.deleteInBatch(messages);

        // 删除全部
        // 删除所有：先findAll，然后一条一条删除，最后提交事务
        messageRepository.deleteAll();
        // 删除所有：使用一条 sql
        messageRepository.deleteAllInBatch();
    }

    @Autowired
    private MessageService messageService;

    @Test
    public void testUpdate() {
        // 根据主键更新
        Message message = Message.builder().msgId(7)
                .msgText("笔记本").msgSummary("学习").build();
        messageRepository.saveAndFlush(message);

        // 批量更新
        List<Message> messages = new ArrayList<>();
        messages.add(Message.builder().msgId(8).msgText("笔记本").msgSummary("学习").build());
        messages.add(Message.builder().msgId(9).msgText("开学").msgSummary("学习").build());
        messageService.batchUpdate(messages);
    }

    // 简单查询
    @Test
    public void testSelect() {
        // 查询所有
        messageRepository.findAll().forEach(msg -> log.info(msg.toString()));

        // 分页查询全部，返回封装了的分页信息， jpa页码从0开始
        Page<Message> pageInfo = messageRepository.findAll(
                PageRequest.of(1, 3, Sort.Direction.ASC, "msgId"));
        log.info("分页查询结果： ");
        pageInfo.get().forEach(System.out::print);

        // 条件查询
        Message message = Message.builder().msgSummary("水果").build();
        List<Message> messages = messageRepository.findAll(Example.of(message));
        log.info("满足summary是水果的message有：");
        messages.forEach(msg -> log.info(msg.toString()));

        // 单个查询
        Message msg = Message.builder().msgId(2).build();
        Optional<Message> optionalMessage = messageRepository.findOne(Example.of(msg));
        log.info("单个查询结果： {}", optionalMessage.orElse(null));
    }

    // 解析方法名创建查询

}
