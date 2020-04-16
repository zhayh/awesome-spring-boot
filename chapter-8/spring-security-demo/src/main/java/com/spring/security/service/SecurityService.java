package com.spring.security.service;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

/**
 * @author : zhayh
 * @date : 2020-4-15 21:01
 * @description :
 */
//@Service
public class SecurityService {
    @PreAuthorize("hasRole('admin')")
    public String admin() {
        return "hello admin";
    }

    @Secured("ROLE_user")
    public String user() {
        return "hello user";
    }

    @PreAuthorize("hasAnyRole('admin', 'user')")
    public String hello() {
        return "hello hello";
    }
}
