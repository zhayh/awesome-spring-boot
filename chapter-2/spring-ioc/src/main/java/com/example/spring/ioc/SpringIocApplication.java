package com.example.spring.ioc;

import com.example.spring.ioc.controller.TestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class SpringIocApplication implements CommandLineRunner {
    @Autowired
    private TestController testController;

    public static void main(String[] args) {
        SpringApplication.run(SpringIocApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        testController.save();
    }
}
