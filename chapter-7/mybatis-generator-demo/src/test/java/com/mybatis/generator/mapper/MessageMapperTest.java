package com.mybatis.generator.mapper;

import com.mybatis.generator.mapper.generator.MessageMapper;
import com.mybatis.generator.model.generator.Message;
import com.mybatis.generator.model.generator.MessageExample;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

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
        // insert into message(msg_text, msg_summary) values (#{msgText}, #{msgSummary})
        Message message = new Message();
        message.setMsgText("orange");
        message.setMsgSummary("水果");
        int num = messageMapper.insertSelective(message);
        log.info("插入的数据条数： {}", num);
    }

//    @Test
//    @Order(2)
//    public void testBatchInsert() {
//        List<Message> messages = new ArrayList<>(Arrays.asList(
//                new Message().withMsgText("niit").withMsgSummary("学校"),
//                new Message().withMsgText("niit").withMsgSummary("学校")));
//        int num = messageMapper.batchInsert(messages);
//        log.info("插入的数据条数： {}", num);
//    }

    @Test
    @Order(3)
    public void testSelectAll() {
        // select * from message
        messageMapper.selectByExample(null).forEach(
                message -> log.info("查询的数据： {}", message.toString()));
    }

    @Test
    @Order(4)
    public void testUpdate() {
        // update message set msg_text = #{msgText}, msg_summary = #{msgSummary} where msg_id = #{msgId}
        Message message = new Message();
        message.setMsgId(1);
        message.setMsgText("computer");
        message.setMsgSummary("学校");
        int num = messageMapper.updateByPrimaryKey(message);
        log.info("更新的数据条数： {}", num);
    }

    @Test
    @Order(5)
    public void testUpdateText() {
        // update message set msg_text = #{msgText} where msg_id = #{msgId}
        Message message = new Message();
        message.setMsgText("computer");
        MessageExample messageExample = new MessageExample();
        messageExample.createCriteria().andMsgSummaryLike("水果" +
                "");
        int num = messageMapper.updateByExampleSelective(message, messageExample);
        log.info("更新Text的数据条数： {}", num);
    }

    @Test
    @Order(6)
    public void testSelectById() {
        // select * from message where msg_id = #{msgId}
        MessageExample messageExample = new MessageExample();
        messageExample.createCriteria().andMsgIdEqualTo(8);
        Message message = messageMapper.selectByExample(messageExample).get(0);
        log.info("id为1的数据： {}", message);
    }

    @Test
    @Order(7)
    public void testFindByCondition() {
        // select * from message where msg_text = #{msgText}
        MessageExample messageExample = new MessageExample();
        messageExample.createCriteria().andMsgSummaryEqualTo("学校");
        Message message = messageMapper.selectByExample(messageExample).get(0);
        log.info("id为1的数据： {}", message);
    }
    @Test
    @Order(8)
    public void testDelete() {
        // delete from message where msg_id = #{msgId}
        MessageExample messageExample = new MessageExample();
        messageExample.createCriteria().andMsgIdEqualTo(2);
        int num = messageMapper.deleteByExample(messageExample);
        log.info("删除的数据条数： {}", num);
    }
}
