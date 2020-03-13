package soft.spring.bean.ioc.annotation.auto.bootstrap;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import soft.spring.bean.ioc.annotation.auto.annotation.EnableHelloWorld;

/**
 * @author : zhayh
 * @date : 2020-3-13 09:55
 * @description : {@link EnableAutoConfiguration} 引导类
 */

@EnableHelloWorld
public class EnableHelloWorldBootstrap {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = new SpringApplicationBuilder(EnableHelloWorldBootstrap.class)
                .web(WebApplicationType.NONE)
                .run(args);

        // helloWorld Bean是否存在
        String helloWorld = context.getBean("helloWorld", String.class);
        System.out.println("helloWorld Bean: " + helloWorld);

        // 关闭上下文
        context.close();
    }
}
