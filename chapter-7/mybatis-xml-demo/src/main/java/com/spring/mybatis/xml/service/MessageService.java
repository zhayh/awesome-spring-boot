package com.spring.mybatis.xml.service;

import com.spring.mybatis.xml.model.Message;

import java.util.List;

/**
 * @author : zhayh
 * @Date : 2020-4-6 16:16
 * @Description:
 */
public interface MessageService {
    List<Message> findAll();

    Message findById(Integer id);

    int insert(Message message);

    int delete(Integer id);

    int update(Message message);

    int updateText(Message message);
}
