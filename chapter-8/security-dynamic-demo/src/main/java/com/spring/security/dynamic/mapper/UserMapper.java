package com.spring.security.dynamic.mapper;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.spring.security.dynamic.model.User;
import com.spring.security.dynamic.model.Role;

import java.util.List;

/**
 * @author : zhayh
 * @date : 2020-4-15 22:04
 * @description :
 */

public interface UserMapper {
    @Select("select * from user where username = #{username}")
    User loadUserByUsername(String username);

    @Select({"select * from role r ",
            "left join user_role ur ",
            "on r.id = ur.rid",
            "where ur.uid = #{id}"})
    List<Role> getUserRolesById(Integer id);
}
