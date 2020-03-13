package soft.spring.bean.ioc.annotation.auto.configuration;

import org.springframework.context.annotation.Configuration;
import soft.spring.bean.ioc.annotation.auto.annotation.EnableHelloWorld;
import soft.spring.bean.ioc.annotation.auto.condition.ConditionalOnSystemProperty;

/**
 * @author : zhayh
 * @date : 2020-3-13 09:44
 * @description : HelloWorld 自动装配
 */

@Configuration // Spring 模式注解装配
@EnableHelloWorld   // Spring @Enable 模块装配
@ConditionalOnSystemProperty(name = "user.name", value = "zhayh") // 条件装配
public class HelloWorldAutoConfiguration {

}
