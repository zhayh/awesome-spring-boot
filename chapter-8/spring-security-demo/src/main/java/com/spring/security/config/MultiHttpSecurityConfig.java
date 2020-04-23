package com.spring.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author : zhayh
 * @date : 2020-4-15 20:19
 * @description :
 */
//@Configuration
//@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
public class MultiHttpSecurityConfig {
    @Bean
    PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
//        return new BCryptPasswordEncoder();
    }

    @Autowired
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // 使用内存进行身份认证
        auth.inMemoryAuthentication()
                .withUser("admin").password("111").roles("admin")  // 配置用户名、密码和角色
                .roles("admin")  // 配置用户名、密码和角色
                .and()
                .withUser("user").password("111").roles("user")
                .roles("user");
    }

//    @Configuration
//    @Order(1)
    public static class AdminSecurityConfig extends WebSecurityConfigurerAdapter {
        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http.antMatcher("/admin/**")   // admin角色才能访问的配置
                    .authorizeRequests()
                    .anyRequest()
                    .hasAnyRole("admin");
        }
    }

//    @Configuration
    public static class OtherSecurityConfig extends WebSecurityConfigurerAdapter {
        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http.authorizeRequests()  // 其它权限的访问
                    .anyRequest()
                    .authenticated()
                    .and()
                    .formLogin()
                    .loginProcessingUrl("/doLogin")
                    .permitAll()
                    .and()
                    .csrf().disable();
        }
    }
}
