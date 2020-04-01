package com.spring.data.datasource.repository;

import com.spring.data.datasource.model.Message;

import java.util.List;

/**
 * @author : zhayh
 * @Date : 2020-2-18 09:09
 * @Description: Message的数据访问接口
 */
public interface MessageRepository {
    List<Message> findAll();

    Message findOne(Long id);

    int save(Message message);

    int delete(Long id);

    int update(Message message);

    int updateText(Message message);
}
