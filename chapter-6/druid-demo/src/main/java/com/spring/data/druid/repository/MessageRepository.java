package com.spring.data.druid.repository;

import com.spring.data.druid.model.Message;

import java.sql.SQLException;
import java.util.List;

/**
 * @author : zhayh
 * @Date : 2020-2-18 09:09
 * @Description: Message的数据访问接口
 */
public interface MessageRepository {
    List<Message> findAll();

    Message findById(Integer id);

    int insert(Message message);

    int[] batchInsert(List<Message> messages);

    int delete(Integer id);

    int update(Message message);

    int updateText(Message message);

    Long count() ;
}
