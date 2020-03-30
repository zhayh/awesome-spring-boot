package com.spring.data.repository.impl;

import com.spring.data.model.Message;
import com.spring.data.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * @author : zhayh
 * @date : 2020-2-18 09:13
 * @description : Message的数据接口实现类
 */

@Repository
public class MessageRepositoryImpl implements MessageRepository {
    @Autowired
    private JdbcTemplate primaryJdbcTemplate;

    @Override
    public List<Message> findAll(JdbcTemplate jdbcTemplate) {
        if (jdbcTemplate == null) {
            jdbcTemplate = this.primaryJdbcTemplate;
        }
        return jdbcTemplate.query("select * from message", new UserRowMapper());
//        return jdbcTemplate.query("select * from message",
//                new BeanPropertyRowMapper<>(Message.class));
    }

    @Override
    public Message findOne(Long id, JdbcTemplate jdbcTemplate) {
        if (jdbcTemplate == null) {
            jdbcTemplate = this.primaryJdbcTemplate;
        }
        return jdbcTemplate.queryForObject("select * from message where id=?",
                new Object[]{id},
                new BeanPropertyRowMapper<>(Message.class));
    }

    @Override
    public int save(Message message, JdbcTemplate jdbcTemplate) {
        if (jdbcTemplate == null) {
            jdbcTemplate = this.primaryJdbcTemplate;
        }
        return jdbcTemplate.update("insert into message(content,summary) values(?,?)",
                message.getContent(), message.getSummary());
    }

    @Override
    public int delete(Long id, JdbcTemplate jdbcTemplate) {
        if (jdbcTemplate == null) {
            jdbcTemplate = this.primaryJdbcTemplate;
        }
        return jdbcTemplate.update("delete from message where id=?", id);
    }

    @Override
    public int update(Message message, JdbcTemplate jdbcTemplate) {
        if (jdbcTemplate == null) {
            jdbcTemplate = this.primaryJdbcTemplate;
        }
        return jdbcTemplate.update("update message set content=? and summary=? where id=?",
                message.getContent(), message.getSummary(), message.getId());
    }

    @Override
    public int updateContent(Message message, JdbcTemplate jdbcTemplate) {
        if (jdbcTemplate == null) {
            jdbcTemplate = this.primaryJdbcTemplate;
        }
        return jdbcTemplate.update("update message set content=? where id=?",
                message.getContent(), message.getId());
    }

    private static class UserRowMapper implements RowMapper<Message> {
        @Override
        public Message mapRow(ResultSet rs, int rowNum) throws SQLException {
            return Message.builder()
                    .id(rs.getLong("id"))
                    .content(rs.getString("content"))
                    .summary(rs.getString("summary"))
                    .build();
        }
    }
}
