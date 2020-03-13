package soft.spring.bean.ioc.annotation.demo3;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author : zhayh
 * @date : 2020-2-10 17:56
 * @description : 对于没有注解的普通Java类，配合使用@Configuration注解才能被IoC容器识别
 */
@Configuration
public class DaoConfiguration {
    // 使用@Bean定义没有被@component注解的普通java类
    @Bean
    CustomDao customDao() {
        return new CustomDao();
    }
}
