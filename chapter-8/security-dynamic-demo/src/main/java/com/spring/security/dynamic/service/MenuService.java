package com.spring.security.dynamic.service;

import com.spring.security.dynamic.mapper.MenuMapper;
import com.spring.security.dynamic.model.Menu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author : zhayh
 * @date : 2020-4-16 20:14
 * @description :
 */
@Service
public class MenuService {
    @Resource
    private MenuMapper menuMapper;

    public List<Menu> getAllMenus() {
        return menuMapper.getAllMenus();
    }
}
