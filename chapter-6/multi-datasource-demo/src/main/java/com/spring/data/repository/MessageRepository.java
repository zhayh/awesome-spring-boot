package com.spring.data.repository;

import com.spring.data.model.Message;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * @author : zhayh
 * @Date : 2020-2-18 09:09
 * @Description: Message的数据访问接口
 */
public interface MessageRepository {
    List<Message> findAll(JdbcTemplate jdbcTemplate);

    Message findOne(Long id, JdbcTemplate jdbcTemplate);

    Long getCount(JdbcTemplate jdbcTemplate);

    int save(Message message, JdbcTemplate jdbcTemplate);

    int[] batchInsert(List<Message> messages, JdbcTemplate jdbcTemplate);

    int delete(Long id, JdbcTemplate jdbcTemplate);

    int update(Message message, JdbcTemplate jdbcTemplate);

    int updateContent(Message message, JdbcTemplate jdbcTemplate);
}
