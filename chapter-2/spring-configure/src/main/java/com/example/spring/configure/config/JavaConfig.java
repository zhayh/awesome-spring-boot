package com.example.spring.configure.config;

import com.example.spring.configure.controller.UserController;
import com.example.spring.configure.dao.UserDao;
import com.example.spring.configure.dao.UserDaoImpl;
import com.example.spring.configure.dao.UserDaoMysqlImpl;
import com.example.spring.configure.service.UserService;
import com.example.spring.configure.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;

/**
 * @author : zhayh
 * @date : 2021-2-25 18:13
 * @description :
 */

@Configuration
//@PropertySource("classpath:jdbc.properties")  // 属性文件可以自定义
public class JavaConfig {
    @Bean
    public UserDao userDao() {
        return new UserDaoImpl();
    }

    @Bean
    public UserDao userDaoMysql() {
        return new UserDaoMysqlImpl();
    }

    @Bean
    public UserService userService() {
        UserService userService = new UserServiceImpl();
        // 将userDao注入到userService中
        userService.setUserDao(userDaoMysql());
        return userService;
    }

    @Bean
    public UserController userController() {
        UserController controller = new UserController();
        // 将userService注入到userController中
        controller.setUserService(userService());
        return controller;
    }

    @Value("${jdbc.url}")
    String url;
    @Value("${jdbc.driverClassName}")
    String driverClassName;
    @Value("${jdbc.username}")
    String username;
    @Value("${jdbc.password}")
    String password;

    @Bean
    @ConfigurationProperties(prefix = "jdbc")  // 属性在默认的application.properties中，不能用于yml文件
    public DataSource dataSource() {
        return DataSourceBuilder.create().build();
    }
}
