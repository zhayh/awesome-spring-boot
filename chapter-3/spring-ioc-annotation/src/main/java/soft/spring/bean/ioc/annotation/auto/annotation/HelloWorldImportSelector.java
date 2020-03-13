package soft.spring.bean.ioc.annotation.auto.annotation;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;
import soft.spring.bean.ioc.annotation.auto.configuration.HelloWorldConfiguration;

/**
 * @author : zhayh
 * @date : 2020-3-13 10:06
 * @description : {@link ImportSelector} 实现
 */

public class HelloWorldImportSelector implements ImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata annotationMetadata) {
        return new String[]{HelloWorldConfiguration.class.getName()};
    }
}
