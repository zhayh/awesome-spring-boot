package com.spring.mybatis.xml.service.impl;

import com.spring.mybatis.xml.mapper.MessageMapper;
import com.spring.mybatis.xml.model.Message;
import com.spring.mybatis.xml.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author : zhayh
 * @date : 2020-4-6 16:18
 * @description :
 */

@Service
public class MessageServiceImpl implements MessageService {
    @Autowired
    private MessageMapper messageMapper;

    @Override
    public List<Message> findAll() {
        return messageMapper.selectAll();
    }

    @Override
    public Message findById(Integer id) {
        return messageMapper.selectById(id);
    }

    @Override
    public int insert(Message message) {
        return messageMapper.insert(message);
    }

    @Override
    public int delete(Integer id) {
        return messageMapper.delete(id);
    }

    @Override
    public int update(Message message) {
        return messageMapper.update(message);
    }

    @Override
    public int updateText(Message message) {
        return messageMapper.updateText(message);
    }
}
