package soft.spring.bean.ioc.annotation.auto.condition;

import org.springframework.context.annotation.Conditional;

import java.lang.annotation.*;

/**
 * @author : zhayh
 * @date : 2020-3-13 10:20
 * @description : Java 系统属性 条件判断
 */

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
@Documented
@Conditional(OnSystemPropertyCondition.class)
public @interface ConditionalOnSystemProperty {
    /**
     * Java 系统属性名称
     * @return
     */
    String name();

    /**
     * Java 系统属性值
     * @return
     */
    String value();
}
