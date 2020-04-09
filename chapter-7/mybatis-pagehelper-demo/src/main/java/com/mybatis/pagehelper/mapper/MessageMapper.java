package com.mybatis.pagehelper.mapper;

import com.mybatis.pagehelper.model.Message;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author : zhayh
 * @Date : 2020-4-6 10:22
 * @Description:
 */

@Mapper
@Repository
public interface MessageMapper {
    @Select("select * from message")
    @Results({
            @Result(property = "msgText", column = "msg_text"),
            @Result(property = "msgSummary", column = "msg_summary")
    })
    List<Message> selectAll();

    @Select("select * from message where msg_id=#{msgId}")
    Message selectById(@Param("msgId") Integer id);

    @Select("select * from message where msg_text=#{msgText} or msg_summary=#{msgSummary}")
    List<Message> selectByTextAndSummary(Map<String, String> params);

    @Insert("insert into message(msg_text, msg_summary) " +
            "values(#{msgText}, #{msgSummary})")
    int insert(Message message);

    @Insert({"<script> ",
            "insert into message(msg_text, msg_summary) values ",
            "<foreach collection ='list' item='msg' index= 'index' separator =','> ",
            "(#{msg.msgText}, #{msg.msgSummary}) ",
            "</foreach> ",
            "</script>"})
    int batchInsert(List<Message> message);

    @Update({"<script> ",
            "update message ",
            "<set> ",
            " <if test='msgText != null'>msg_text=#{msgText},</if> ",
            " <if test='msgSummary != null'>msg_summary=#{msgSummary}</if> ",
            "</set> ",
            "where msg_id=#{msgId} ",
            "</script>"})
    int update(Message message);

    @Update({"<script> ",
            "update message ",
            "<set> ",
            " <if test='msgText != null'>msg_text=#{msgText}</if> ",
            "</set> ",
            "where msg_id=#{msgId} ",
            "</script>"})
    int updateText(Message message);

    @Delete("delete from message where msg_id=#{msgId} ")
    int delete(@Param("msgId") Integer id);

    @Select("select * from message order by msg_id")
    List<Message> findAllWithRowBounds(RowBounds rowBounds);

    @Select("select * from message order by msg_id")
    List<Message> findALlWithParam(@Param("pageNum") int pageNum,
                                  @Param("pageSize") int pageSize);
}
