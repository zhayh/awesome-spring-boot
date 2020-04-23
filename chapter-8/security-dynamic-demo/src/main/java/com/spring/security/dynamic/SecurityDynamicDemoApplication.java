package com.spring.security.dynamic;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.spring.security.dynamic.mapper")
public class SecurityDynamicDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SecurityDynamicDemoApplication.class, args);
    }

}
