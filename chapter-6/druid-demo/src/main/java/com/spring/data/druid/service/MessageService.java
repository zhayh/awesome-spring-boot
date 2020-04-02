package com.spring.data.druid.service;

import com.spring.data.druid.exception.RollbackException;
import com.spring.data.druid.model.Message;

/**
 * @author : zhayh
 * @Date : 2020-4-1 22:08
 * @Description: Message的service接口
 */
public interface MessageService {
    void insertRecord(Message message);

    void insertThenRollback(Message message) throws RollbackException;

    void invokeInsertThenRollback(Message message) throws RollbackException;
}
