package edu.niit.springboot.bootstrap;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.HashSet;
import java.util.Set;

/**
 * @author : zhayh
 * @date : 2020-3-13 08:23
 * @description : 引导类
 */
//@SpringBootApplication
public class SpringApplicationBootstrap {

    public static void main(String[] args) {
        // 默认SpringApplication启动
//        SpringApplication.run(ApplicationConfiguration.class, args);

        // 通过SpringApplication API自定义SpringApplication的启动参数
        // 配置Class名称
        Set<String> sources = new HashSet<>();
        sources.add(ApplicationConfiguration.class.getName());

        SpringApplication springApplication = new SpringApplication();
        springApplication.setSources(sources);
        // 关闭默认Web配置
        springApplication.setWebApplicationType(WebApplicationType.NONE);
        springApplication.setAdditionalProfiles("dev");
        springApplication.setBannerMode(Banner.Mode.OFF);
        springApplication.setHeadless(true);

        springApplication.run(args);

        // 通过SpringApplicationBuilder API自定义SpringApplication的启动参数
//        new SpringApplicationBuilder(ApplicationConfiguration.class)
//                .bannerMode(Banner.Mode.OFF)
//                .web(WebApplicationType.NONE)
//                .profiles("dev")
//                .headless(true)
//                .run(args);
    }

    @SpringBootApplication
    public static class ApplicationConfiguration {

    }
}
