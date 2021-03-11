package com.example.spring.configure;

import com.example.spring.configure.controller.UserController;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.Connection;

@SpringBootApplication
public class SpringConfigureApplication implements CommandLineRunner {
    @Resource
    private DataSource dataSource;

    @Resource
    private UserController userController;

    public static void main(String[] args) {
        SpringApplication.run(SpringConfigureApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println(dataSource);
        userController.save();
    }
}
