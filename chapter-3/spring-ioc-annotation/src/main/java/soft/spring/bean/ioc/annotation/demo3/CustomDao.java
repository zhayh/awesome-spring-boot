package soft.spring.bean.ioc.annotation.demo3;

/**
 * @author : zhayh
 * @date : 2020-2-10 17:21
 * @description :
 */

/**
 * 对于没有注解的普通Java类，配合使用@Configuration注解
 * 才能被IoC容器识别
 */
public class CustomDao {
    public void save() {
        System.out.println("ProduceDao的save()执行了......");
    }
}
