package soft.spring.bean.ioc.annotation.auto.annotation;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @author : zhayh
 * @date : 2020-3-13 10:04
 * @description : 激活HelloWorld模块
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
@Import(HelloWorldImportSelector.class)
public @interface EnableHelloWorld {
}
