package com.spring.security.dynamic.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.Collection;

/**
 * @author : zhayh
 * @date : 2020-4-16 22:44
 * @description : 授权
 */
@Component
public class CustomAccessDecisionManager implements AccessDecisionManager {
    /**
     *
     * @param authentication 当前登录用户的信息
     * @param object FilterInvcation对象，可获取当前请求对象等信息
     * @param collection 当前请求 URL所需要的角色的集合
     * @throws AccessDeniedException
     * @throws InsufficientAuthenticationException
     */
    @Override
    public void decide(Authentication authentication, Object object,
                       Collection<ConfigAttribute> collection)
            throws AccessDeniedException, InsufficientAuthenticationException {
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
        for (ConfigAttribute attribute : collection) {
            if("ROLE_login".equals(attribute.getAttribute())) {
                if(authentication instanceof AnonymousAuthenticationToken) {
                    throw new AccessDeniedException("非法请求");
                } else {
                    return;
                }
            }
            for (GrantedAuthority authority : authorities) {
                if(authority.getAuthority().equals(attribute.getAttribute())) {
                    return;
                }
            }
        }
        throw new AccessDeniedException("权限不足");
    }

    @Override
    public boolean supports(ConfigAttribute configAttribute) {
        return true;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }
}
