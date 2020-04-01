package com.spring.data.datasource.repository.impl;

import com.spring.data.datasource.model.Message;
import com.spring.data.datasource.repository.MessageRepository;
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
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Message> findAll() {
        return jdbcTemplate.query("select * from message", new UserRowMapper());
//        return jdbcTemplate.query("select * from message",
//                new BeanPropertyRowMapper<>(Message.class));
    }

    @Override
    public Message findOne(Long id) {
        return jdbcTemplate.queryForObject("select * from message where id=?",
                new Object[]{id},
                new BeanPropertyRowMapper<Message>(Message.class));
    }

    @Override
    public int save(Message message) {
        return jdbcTemplate.update("insert into message(text, summary) values(?, ?)",
                message.getText(), message.getSummary());
    }

    @Override
    public int delete(Long id) {
        return jdbcTemplate.update("delete from message where id=?", id);
    }

    @Override
    public int update(Message message) {
        return jdbcTemplate.update("update message set text=? and summary=? where id=?",
                message.getText(), message.getSummary(), message.getId());
    }

    @Override
    public int updateText(Message message) {
        return jdbcTemplate.update("update message set text=? where id=?",
                message.getText(), message.getId());
    }

    private static class UserRowMapper implements RowMapper<Message> {
        @Override
        public Message mapRow(ResultSet rs, int rowNum) throws SQLException {
            return Message.builder()
                    .id(rs.getLong("id"))
                    .text(rs.getString("text"))
                    .summary(rs.getString("summary"))
                    .build();
        }
    }
}
