package soft.spring.bean.ioc.annotation.auto.configuration;

import org.springframework.context.annotation.Bean;

/**
 * @author : zhayh
 * @date : 2020-3-13 15:51
 * @description : HelloWorld 配置
 */
public class HelloWorldConfiguration {
    @Bean
    public String helloWorld() { // 方法名即 Bean 名称
        return "Hello World";
    }
}
