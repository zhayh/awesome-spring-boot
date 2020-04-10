package com.spring.jpa.mysql.service;

import com.spring.jpa.mysql.model.Message;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @author : zhayh
 * @Date : 2020-4-10 09:15
 * @Description:
 */
public interface MessageService {
    void save(Message message);
    void batchSave(List<Message> messages);

    void delete(Integer id);
    void batchDelete(List<Message> messages);
    void deleteAll();

    void update(Message message);
    void batchUpdate(List<Message> messages);

    long count();

    Message getMessage(Integer id);
    List<Message> getAll();

}
