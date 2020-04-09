package com.spring.batis.annotation.mapper;

import com.spring.batis.annotation.model.Message;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
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
public class MessageMapperTest {
    @Resource
    private MessageMapper messageMapper;

    @Test
    @Order(1)
    public void testInsert() {
        Message message = Message.builder().msgText("niit").msgSummary("学校").build();
        int num = messageMapper.insert(message);
        log.info("插入的数据条数： {}", num);
    }

    @Test
    @Order(2)
    public void testBatchInsert() {
        List<Message> messages = new ArrayList<>(Arrays.asList(
                Message.builder().msgText("apple").msgSummary("水果").build(),
                Message.builder().msgText("orange").msgSummary("水果").build()));
        int num = messageMapper.batchInsert(messages);
        log.info("插入的数据条数： {}", num);
    }

    @Test
    @Order(3)
    public void testSelectdAll() {
        List<Message> msgs = messageMapper.selectAll();
        if(msgs == null) {
            log.error("msg为null");
        } else {
            msgs.forEach(msg -> log.info("查询到的记录： {}", msg));
        }
    }

    @Test
    @Order(4)
    public void testUpdate() {
        Message message = Message.builder().msgId(1).msgText("computer").msgSummary("学校").build();
        int num = messageMapper.update(message);
        log.info("更新的数据条数： {}", num);
    }

    @Test
    @Order(5)
    public void testUpdateText() {
        Message message = Message.builder().msgId(2).msgText("computer")
                .msgSummary("").build();
        int num = messageMapper.updateText(message);
        log.info("更新Text的数据条数： {}", num);
    }

    @Test
    @Order(6)
    public void testSelectById() {
        Message message = messageMapper.selectById(1);
        log.info("id为1的数据： {}", message);
    }

    @Test
    @Order(7)
    public void testDelete() {
        int num = messageMapper.delete(1);
        log.info("删除的数据条数： {}", num);
    }

    @Test
    public void testSelectByCondition1() {
        Message message = Message.builder().msgId(2).msgText("niit").msgSummary("学校").build();
        messageMapper.selectByCondition(message).forEach(
                msg -> log.info("查询的数据： {}", msg.toString()));
    }

    // 演示SqlSessionFactory、SqlSession的应用
//    @Test
//    public void testSelectOne() throws IOException {
//        String resource = "mybatis-config.xml";
//        InputStream inputStream = new ClassPathResource(resource).getInputStream();
//        SqlSessionFactory sqlSessionFactory =
//                new SqlSessionFactoryBuilder().build(inputStream);
//        SqlSession sqlSession = sqlSessionFactory.openSession();
//        Message message = sqlSession.selectOne("com.spring.mybatis.xml.mapper.MessageMapper.selectById", 8);
//        log.info(message.toString());
//        sqlSession.close();
//    }
}
