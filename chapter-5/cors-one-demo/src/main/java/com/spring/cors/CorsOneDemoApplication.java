package com.spring.cors;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class CorsOneDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(CorsOneDemoApplication.class, args);
    }

    // 全局跨域
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**") //配置允许跨域的路径
                        .allowedOrigins("http://localhost:8081") //配置允许访问的跨域资源的请求域名
                        .allowedHeaders("*")//配置允许请求header的访问，如 ：X-TOKEN
                        .allowedMethods("*") //配置允许访问该跨域资源服务器的请求方法，如：POST、GET、PUT、DELETE等
                        .maxAge(30 * 1000);
            }
        };
    }
}
