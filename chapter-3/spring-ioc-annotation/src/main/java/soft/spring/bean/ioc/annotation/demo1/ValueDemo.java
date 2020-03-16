package soft.spring.bean.ioc.annotation.demo1;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * @author : zhayh
 * @date : 2020-3-13 19:04
 * @description : 属性输入类
 */

/**
 * @Value的使用 ${}:获取属性文件的值
 * #{}: 内容必须符合SpEL表达式
 */
@Data
@Component
@PropertySource({"classpath:value.properties"})
//@ConfigurationProperties(prefix = "user")  // 只能从默认的properties文件获取
public class ValueDemo {
    @Value("${user.fullName}")
    private String userName;

    @Value("${user.address}")
    private String address;

    // 数组的注入
    @Value("${user.preferences}")
    private List<String> preferences;

    // Map的注入
    @Value("#{${products.count}}")
    private Map<String, Integer> productsCount;

    // Map的特定key的值注入
    @Value("#{${products.count}.P1}")
    private Integer p1Count;

    // 读取系统变量
    @Value("${java.home}")
    private String javaHome;

    // 使用SpEL表达式
//    @Value("#{systemProperties['java.home']}")
//    private String javaHome;

    // 指派默认值
    @Value("${user.stocks:30}")
    private int stockCount;

    // 方法上注入
    @Value("${user.name}")
    public void setUserName(String userName) {
        this.userName = userName;
    }

    // 参数注入
    public void setUserDetails(@Value("${user.fullName") String userName,
                               @Value("${user.address") String address) {
        this.userName = userName;
        this.address = address;
    }


}
