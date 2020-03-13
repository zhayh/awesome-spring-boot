package soft.spring.bean.ioc.annotation.auto.bootstrap;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import soft.spring.bean.ioc.annotation.auto.condition.ConditionalOnSystemProperty;

/**
 * @author : zhayh
 * @date : 2020-3-13 10:30
 * @description : 系统属性条件引导类
 */

public class ConditionalOnSystemPropertyBootstrap {
    @Bean
    @ConditionalOnSystemProperty(name = "user.name", value = "zhayh")
    public String helloWorld() {
        return "Hello World by condition";
    }
    public static void main(String[] args) {
        ConfigurableApplicationContext context = new SpringApplicationBuilder(ConditionalOnSystemPropertyBootstrap.class)
                .web(WebApplicationType.NONE)
                .run(args);

        // 通过名称和类型获取 helloWorld Bean
        String helloWorld = context.getBean("helloWorld", String.class);
        System.out.println("helloWorld Bean: " + helloWorld);
        // 关闭上下文
        context.close();
    }
}
