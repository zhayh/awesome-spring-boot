package com.spring.security.dynamic.config;

import com.spring.security.dynamic.model.Menu;
import com.spring.security.dynamic.model.Role;
import com.spring.security.dynamic.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;

import java.util.Collection;
import java.util.List;

/**
 * @author : zhayh
 * @date : 2020-4-16 20:11
 * @description :
 */
@Component
public class MenuFilter implements FilterInvocationSecurityMetadataSource {
    private AntPathMatcher pathMatcher = new AntPathMatcher();

    @Autowired
    MenuService menuService;

    @Override
    public Collection<ConfigAttribute> getAttributes(Object o) throws IllegalArgumentException {
        String requestUrl = ((FilterInvocation) o).getRequestUrl();
        List<Menu> allMenus = menuService.getAllMenus();
        for (Menu menu : allMenus) {
            if(pathMatcher.match(menu.getPattern(), requestUrl)) {
                return SecurityConfig.createList(menu.getRoles().stream().map(Role::getName).toArray(String[]::new));
            }
        }
        return SecurityConfig.createList("ROLE_login");
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return false;
    }
}
