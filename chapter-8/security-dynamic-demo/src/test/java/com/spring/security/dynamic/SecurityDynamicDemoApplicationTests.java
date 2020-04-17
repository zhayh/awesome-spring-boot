package com.spring.security.dynamic;

import com.spring.security.dynamic.mapper.UserMapper;
import com.spring.security.dynamic.service.MenuService;
import com.spring.security.dynamic.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class SecurityDynamicDemoApplicationTests {
    @Autowired
    MenuService menuService;

    @Autowired
    UserService userService;

    @Test
    void contextLoads() {
        System.out.println(menuService.getAllMenus());
        System.out.println(userService.loadUserByUsername("root"));
    }

}
