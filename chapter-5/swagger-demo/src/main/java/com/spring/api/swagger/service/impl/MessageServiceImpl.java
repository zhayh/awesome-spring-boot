package com.spring.api.swagger.service.impl;

import com.spring.api.swagger.exception.CustomException;
import com.spring.api.swagger.pojo.Message;
import com.spring.api.swagger.repository.MessageRepository;
import com.spring.api.swagger.service.MessageService;
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
    public Message save(Message message) throws CustomException {
        return repository.save(message);
    }

    @Override
    public void delete(Long id) {
        repository.delete(id);
    }

    @Override
    public Message update(Message message) throws CustomException {
        return repository.update(message);
    }

    @Override
    public Message updateText(Message message) throws CustomException {
        return repository.updateText(message);
    }
}
