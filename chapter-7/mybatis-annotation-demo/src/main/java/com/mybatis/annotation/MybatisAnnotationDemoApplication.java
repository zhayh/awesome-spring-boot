package com.mybatis.annotation;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MybatisAnnotationDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(MybatisAnnotationDemoApplication.class, args);
    }

}
