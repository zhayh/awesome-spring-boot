package com.spring.mybatis.xml;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.spring.mybatis.xml.mapper")
public class MybatisXmlDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(MybatisXmlDemoApplication.class, args);
    }
}
