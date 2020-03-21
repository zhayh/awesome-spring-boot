package com.spring.restful.service.impl;

import com.spring.restful.pojo.Message;
import com.spring.restful.repository.MessageRepository;
import com.spring.restful.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author : zhayh
 * @date : 2020-3-21 11:24
 * @description : 消息服务类
 */

@Service
public class MessageServiceImpl implements MessageService {
    @Autowired
    private MessageRepository repository;

    @Override
    public List<Message> findAll() {
        return repository.findAll();
    }

    @Override
    public Message findOne(Long id) {
        return repository.findOne(id);
    }

    @Override
    public Message save(Message message) {
        return repository.save(message);
    }

    @Override
    public void delete(Long id) {
        repository.delete(id);
    }

    @Override
    public Message update(Message message) {
        return repository.update(message);
    }

    @Override
    public Message updateText(Message message) {
        return repository.updateText(message);
    }
}
