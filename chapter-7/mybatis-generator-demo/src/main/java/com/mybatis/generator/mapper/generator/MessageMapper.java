package com.mybatis.generator.mapper.generator;

import com.mybatis.generator.model.generator.Message;
import com.mybatis.generator.model.generator.MessageExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MessageMapper {
    // 根据条件做count(*)
    long countByExample(MessageExample example);
    // 根据条件删除记录
    int deleteByExample(MessageExample example);
    // 根据表主键删除记录
    int deleteByPrimaryKey(Integer msgId);
    // 插入一条完整记录，record的所有数据都插入表中
    int insert(Message record);
    // 插入一条记录，只插入record对象不为空的属性
    int insertSelective(Message record);
    //查询符合"条件"的对象列表
    List<Message> selectByExample(MessageExample example);
    //根据主键查询对象
    Message selectByPrimaryKey(Integer msgId);
    //根据example将record中不为空的属性更新到表中
    int updateByExampleSelective(@Param("record") Message record, @Param("example") MessageExample example);
    //根据example将record中所有属性更新到表中(所有值覆盖)
    //一旦record属性为空，对应的数据库字段不允许为空，则异常
    int updateByExample(@Param("record") Message record, @Param("example") MessageExample example);
    //根据主键将record中不为空的属性更新到表中
    int updateByPrimaryKeySelective(Message record);
    //根据主键将record中所有属性更新到表中(所有值覆盖)
    int updateByPrimaryKey(Message record);
}
