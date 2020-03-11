package edu.niit.props;

/**
 * 如果Application放在某个包下，就需要使用@ComponentScan注解指明扫描包的路径，如
 *
 * @ComponentScan(basePackages = {"edu.niit.props"})
 */

import org.springframework.boot.Banner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class PropsDemoApplication {

    public static void main(String[] args) {
//        SpringApplication.run(PropsDemoApplication.class, args);

        // 关闭banner
        new SpringApplicationBuilder(PropsDemoApplication.class)
                .bannerMode(Banner.Mode.OFF).run(args);
    }
}
