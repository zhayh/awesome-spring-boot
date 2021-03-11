package com.example.spring.ioc;

import com.example.spring.ioc.controller.UserController;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.Resource;

@SpringBootApplication
public class SpringIocApplication implements CommandLineRunner {
    @Resource
    private UserController userController;

    public static void main(String[] args) {
        SpringApplication.run(SpringIocApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        userController.save();
    }
}
