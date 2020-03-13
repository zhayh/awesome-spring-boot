package soft.spring.bean.ioc.annotation.auto.condition;


import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;
import soft.spring.bean.ioc.annotation.auto.condition.ConditionalOnSystemProperty;

import java.util.Map;

/**
 * @author : zhayh
 * @date : 2020-3-13 10:23
 * @description : 系统属性条件判断
 */
public class OnSystemPropertyCondition implements Condition {
    @Override
    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata metadata) {
        Map<String, Object> attributes =  metadata.getAnnotationAttributes(ConditionalOnSystemProperty.class.getName());
        assert attributes != null;
        String propertyName = String.valueOf(attributes.get("name"));
        String propertyValue = String.valueOf(attributes.get("value"));
        String javaPropertyValue = System.getProperty(propertyName);
        return propertyValue.equals(javaPropertyValue);
    }
}
