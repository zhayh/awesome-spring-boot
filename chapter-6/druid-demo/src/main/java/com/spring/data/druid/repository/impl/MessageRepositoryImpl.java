package com.spring.data.druid.repository.impl;

import com.spring.data.druid.model.Message;
import com.spring.data.druid.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSourceUtils;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author : zhayh
 * @date : 2020-2-18 09:13
 * @description : Message的数据接口实现类
 */

@Repository
public class MessageRepositoryImpl implements MessageRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private SimpleJdbcInsert simpleJdbcInsert;

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public List<Message> findAll() {
        return jdbcTemplate.query("select * from message",
                (rs, rowNum) -> Message.builder()
                .msgId(rs.getInt("msg_id"))
                .msgText(rs.getString("msg_text"))
                .msgSummary(rs.getString("msg_summary"))
                .build());
    }

    @Override
    public Message findById(Integer id) {
        return jdbcTemplate.queryForObject("select * from message where msg_id=?",
                new Object[]{id},
                new BeanPropertyRowMapper<>(Message.class));
    }

    @Override
    public Long count() {
        return jdbcTemplate.queryForObject("select count(*) from message", Long.class);
    }
    @Override
    public int insert(Message message) {
//        return jdbcTemplate.update("insert into message(msg_text, msg_summary) values(?, ?)",
//                message.getMsgText(), message.getMsgSummary());

        // 插入后返回插入数据的id
        Map<String, String> row = new HashMap<>();
        row.put("msg_text", message.getMsgText());
        row.put("msg_summary", message.getMsgSummary());
        Number id = simpleJdbcInsert.executeAndReturnKey(row);
        return id.intValue();
    }

    @Override
    public int[] batchInsert(List<Message> messages) {
//        return jdbcTemplate.batchUpdate("insert into message(msg_text,msg_text) values(?,?)",
//                new BatchPreparedStatementSetter(){
//                    @Override
//                    public void setValues(PreparedStatement ps, int i) throws SQLException {
//                        ps.setString(1, messages.get(i).getMsgText());
//                        ps.setString(2, messages.get(i).getMsgSummary());
//                    }
//                    @Override
//                    public int getBatchSize() {
//                        return messages.size();
//                    }
//                });
        return namedParameterJdbcTemplate.batchUpdate("insert into message(msg_text,msg_summary) values(:msgText,:msgSummary)",
                SqlParameterSourceUtils.createBatch(messages));
    }

    @Override
    public int delete(Integer id) {
        return jdbcTemplate.update("delete from message where msg_id=?", id);
    }

    @Override
    public int update(Message message) {
        return jdbcTemplate.update("update message set msg_text=? and msg_summary=? where msg_id=?",
                message.getMsgText(), message.getMsgSummary(), message.getMsgId());
    }

    @Override
    public int updateText(Message message) {
        return jdbcTemplate.update("update message set msg_text=? where msg_id=?",
                message.getMsgText(), message.getMsgId());
    }

    private static class MessageRowMapper implements RowMapper<Message> {
        @Override
        public Message mapRow(ResultSet rs, int rowNum) throws SQLException {
            return Message.builder()
                    .msgId(rs.getInt("msg_id"))
                    .msgText(rs.getString("msg_text"))
                    .msgSummary(rs.getString("msg_summary"))
                    .build();
        }
    }
}
