package com.spring.data.repository.impl;

import com.spring.data.model.Message;
import com.spring.data.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.SqlParameterSourceUtils;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
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
        return jdbcTemplate.query("select * from message", new MessageRowMapper());
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
    public Long getCount(JdbcTemplate jdbcTemplate) {
        if (jdbcTemplate == null) {
            jdbcTemplate = this.primaryJdbcTemplate;
        }
        return jdbcTemplate.queryForObject("select count(*) from message", Long.class);
    }

    @Override
    public int save(Message message, JdbcTemplate jdbcTemplate) {
        if (jdbcTemplate == null) {
            jdbcTemplate = this.primaryJdbcTemplate;
        }
        return jdbcTemplate.update("insert into message(text,summary) values(?,?)",
                message.getText(), message.getSummary());
    }
    @Override
    public int[] batchInsert(List<Message> messages, JdbcTemplate jdbcTemplate) {
        if (jdbcTemplate == null) {
            jdbcTemplate = this.primaryJdbcTemplate;
        }
        return jdbcTemplate.batchUpdate("insert into message(text,summary) values(?,?)",
                new BatchPreparedStatementSetter(){
            @Override
            public void setValues(PreparedStatement ps, int i) throws SQLException {
                ps.setString(1, messages.get(i).getText());
                ps.setString(2, messages.get(i).getSummary());
            }
            @Override
            public int getBatchSize() {
                return messages.size();
            }
        });
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
        return jdbcTemplate.update("update message set text=? and summary=? where id=?",
                message.getText(), message.getSummary(), message.getId());
    }

    @Override
    public int updateContent(Message message, JdbcTemplate jdbcTemplate) {
        if (jdbcTemplate == null) {
            jdbcTemplate = this.primaryJdbcTemplate;
        }
        return jdbcTemplate.update("update message set text=? where id=?",
                message.getText(), message.getId());
    }

    private static class MessageRowMapper implements RowMapper<Message> {
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
