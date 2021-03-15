package com.example.spring.props;

/**
 * 如果Application放在某个包下，就需要使用@ComponentScan注解指明扫描包的路径，如
 *
 * @ComponentScan(basePackages = {"com.example.spring.props"})
 */

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PropsDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(PropsDemoApplication.class, args);

        // 关闭banner
//          new SpringApplicationBuilder(PropsDemoApplication.class)
//                  .bannerMode(Banner.Mode.OFF).run(args);
    }
}
