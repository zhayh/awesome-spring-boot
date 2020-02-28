package edu.niit.props;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
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
