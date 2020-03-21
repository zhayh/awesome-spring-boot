package com.spring.restful.service;

import com.spring.restful.pojo.Message;

import java.util.List;

/**
 * @author : zhayh
 * @date : 2020-3-21 11:23
 * @description : 消息服务接口
 */
public interface MessageService {
    List<Message> findAll();

    Message findOne(Long id);

    Message save(Message message);

    void delete(Long id);

    Message update(Message message);

    Message updateText(Message message);
}
