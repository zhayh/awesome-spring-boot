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
public class CustomFilter implements FilterInvocationSecurityMetadataSource {
    // URL匹配的 ant风格的对象
    private AntPathMatcher pathMatcher = new AntPathMatcher();

    @Autowired
    MenuService menuService;

    /**
     * 从 Filterlnvocation中提取出当前请求的 URL
     * @param object FilterInvocation对象
     * @return 当前请求URL 所需的角色
     * @throws IllegalArgumentException
     */
    @Override
    public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {
        // 从参数中提取当前请求的 URL
        String requestUrl = ((FilterInvocation) object).getRequestUrl();
        List<Menu> allMenus = menuService.getAllMenus();
        // 遍历 menu资源，获取当前请求的 URL所需要的角色信息并返回
        for (Menu menu : allMenus) {
            if(pathMatcher.match(menu.getPattern(), requestUrl)) {
                return SecurityConfig.createList(menu.getRoles().stream().map(Role::getName).toArray(String[]::new));
            }
        }
        return SecurityConfig.createList("ROLE_login");
    }

    /**
     * Spring Security在启动时校验相关配置是否正确，如果不需要校验，那么该方法直接返回 null即可
     * @return 所有定义好的权限资源
     */
    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    /**
     *
     * @param clazz
     * @return 返回类对象是否支持校验。
     */
    @Override
    public boolean supports(Class<?> clazz) {
        return FilterInvocation.class.isAssignableFrom(clazz);
    }
}
