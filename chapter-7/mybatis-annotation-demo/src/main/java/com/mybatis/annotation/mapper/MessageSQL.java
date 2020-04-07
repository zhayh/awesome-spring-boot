package com.mybatis.annotation.mapper;

import com.mybatis.annotation.model.Message;
import org.apache.ibatis.jdbc.SQL;
import org.springframework.util.StringUtils;

/**
 * @author : zhayh
 * @Date : 2020-2-18 09:09
 * @Description: Message的数据访问接口
 */

public class MessageSQL {
    public String getCount(Message message) {
        return new SQL(){{
            SELECT("count(1)");
            FROM("message");
            if(StringUtils.isEmpty(message.getMsgText())) {
                WHERE("msg_text=#{msgText}");
            }
            if(StringUtils.isEmpty(message.getMsgSummary())) {
                WHERE("msg_summary=#{msgSummary}");
            }
            // 说明SQL内部使用StringBuilder实现SQL拼接
        }}.toString();
    }
}
