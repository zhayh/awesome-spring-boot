package com.mybatis.annotation.mapper;

import com.mybatis.annotation.model.Message;
import com.mybatis.annotation.param.MessageParam;
import org.apache.ibatis.javassist.runtime.Desc;
import org.apache.ibatis.jdbc.SQL;
import org.springframework.util.StringUtils;

/**
 * @author : zhayh
 * @Date : 2020-2-18 09:09
 * @Description: Message的数据访问接口
 */

public class MessageSQL {
    public String getCount(MessageParam messageParam) {
        return new SQL(){{
            SELECT("count(1)");
            FROM("message");
            if(!StringUtils.isEmpty(messageParam.getMsgText())) {
                WHERE("msg_text=#{msgText}");
            }
            if(!StringUtils.isEmpty(messageParam.getMsgSummary())) {
                WHERE("msg_summary=#{msgSummary}");
            }
            // 说明SQL内部使用StringBuilder实现SQL拼接
        }}.toString();
    }

    public String selectMessages(MessageParam messageParam) {
        return new SQL(){{
            SELECT("*");
            FROM("message");
            WHERE("1=1");
            if (messageParam != null) {
                if (!StringUtils.isEmpty(messageParam.getMsgText())) {
                   WHERE(" and msg_text = #{msgText} ");
                }
                if(!StringUtils.isEmpty(messageParam.getMsgSummary())) {
                    WHERE("msg_summary=#{msgSummary}");
                }
            }
            ORDER_BY("msg_id");

            if (messageParam != null) {
                OFFSET(messageParam.getBeginLine());
                LIMIT(messageParam.getPageSize());
            }
        }}.toString();
    }
}
