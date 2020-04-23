package com.spring.security.jwt.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.security.jwt.filter.JwtFilter;
import com.spring.security.jwt.filter.JwtLoginFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.*;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * @author : zhayh
 * @date : 2020-4-15 18:19
 * @description :
 */

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    // Spring 5.0开始，密码必须加密
    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // 使用内存进行身份认证
        auth.inMemoryAuthentication()
                .withUser("admin")
                .password("$2a$10$65mNXiMe8KFc1uiclABDbOhzs.0tEGVxj76pv2VbwIdis1.gYjwoS")
                .roles("admin")  // 配置用户名、密码和角色
                .and()
                .withUser("user")
                .password("$2a$10$065eCWb94lnGrc.nu9NLJuOIArFN/S9svf75NUY3gcpMlTnfrB7v.")
                .roles("user");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests() // 开启配置
                .antMatchers("/admin/**").hasRole("admin") // 配置url路径和角色
                .antMatchers("/user/**").hasAnyRole("admin", "user")
                .antMatchers("/hello").hasRole("user")
                .antMatchers(HttpMethod.POST, "/login")
                .permitAll()
                .anyRequest().authenticated()  // 其它请求登录之后都能访问
                .and()
                .addFilterBefore(new JwtLoginFilter("/login", authenticationManager()),
                        UsernamePasswordAuthenticationFilter.class)
                .addFilterBefore(new JwtFilter(), UsernamePasswordAuthenticationFilter.class)
                .csrf().disable();  // 关闭防 csrf攻击，用于 postman测试
    }
}
