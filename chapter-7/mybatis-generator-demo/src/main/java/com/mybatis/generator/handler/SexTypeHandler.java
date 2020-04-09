package com.mybatis.generator.handler;

import com.mybatis.generator.enumeration.SexEnum;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author : zhayh
 * @date : 2020-2-14 12:51
 * @description : 在Money与Long之间转换的TypeHandler，处理CNY人民币
 */

// 声明JdbcType为整形
@MappedJdbcTypes(JdbcType.INTEGER)
// 声明JavaType为SexEnum
@MappedTypes(value=SexEnum.class)
public class SexTypeHandler extends BaseTypeHandler<SexEnum> {
    // 设置非空性别参数
    @Override
    public void setNonNullParameter(PreparedStatement ps, int idx,
                                    SexEnum sex, JdbcType jdbcType) throws SQLException {
        ps.setInt(idx, sex.getId());
    }

    // 通过列名读取性别
    @Override
    public SexEnum getNullableResult(ResultSet rs, String col) throws SQLException {
        int id = rs.getInt(col);
        if (id != 1 && id != 2) {
            return null;
        }
        return SexEnum.getEnumById(id);
    }

    // 通过下标读取性别
    @Override
    public SexEnum getNullableResult(ResultSet rs, int idx) throws SQLException {
        int id = rs.getInt(idx);
        if (id != 1 && id != 2) {
            return null;
        }
        return SexEnum.getEnumById(id);
    }

    // 通过存储过程读取性别
    @Override
    public SexEnum getNullableResult(CallableStatement cs, int idx) throws SQLException {
        int id = cs.getInt(idx);
        if (id != 1 && id != 2) {
            return null;
        }
        return SexEnum.getEnumById(id);
    }
}

// 1. 在properties文件中配置handler的扫描包
//mybatis.type-handlers-package=com.mybatis.generator.handler.SexTypeHandler
