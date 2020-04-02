package com.spring.data.druid.service.impl;

import com.spring.data.druid.exception.RollbackException;
import com.spring.data.druid.model.Message;
import com.spring.data.druid.repository.MessageRepository;
import com.spring.data.druid.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author : zhayh
 * @date : 2020-4-1 22:18
 * @description : Message的service接口的实现类
 */
@Service
public class MessageServiceImpl implements MessageService {
    @Autowired
    private MessageRepository messageRepository;

    @Override
    @Transactional
    public void insertRecord(Message message) {
        messageRepository.insert(message);
    }

    @Override
    @Transactional(rollbackFor = RollbackException.class)
    public void insertThenRollback(Message message) throws RollbackException {
        messageRepository.insert(message);
        throw new RollbackException();
    }

    @Override
    public void invokeInsertThenRollback(Message message) throws RollbackException {
        insertThenRollback(message);
    }
}
