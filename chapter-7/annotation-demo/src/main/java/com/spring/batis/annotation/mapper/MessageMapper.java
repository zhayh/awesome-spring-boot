package com.spring.mybatis.xml.mapper;


import com.spring.mybatis.xml.model.Message;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.SelectProvider;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author : zhayh
 * @Date : 2020-2-18 09:09
 * @Description: Message的数据访问接口
 */

public interface MessageMapper {

    List<Message> selectAll();

    Message selectById(Integer id);

    int insert(Message message);

    int delete(Integer id);

    int update(Message message);

    int updateText(Message message);

    int batchInsert(List<Message> messages);

    List<Message> selectByCondition(Message message);

}
