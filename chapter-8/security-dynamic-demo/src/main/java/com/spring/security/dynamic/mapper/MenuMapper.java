package com.spring.security.dynamic.mapper;

import com.spring.security.dynamic.model.Menu;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author : zhayh
 * @date : 2020-4-16 20:14
 * @description :
 */
public interface MenuMapper {
    List<Menu> getAllMenus();
}
