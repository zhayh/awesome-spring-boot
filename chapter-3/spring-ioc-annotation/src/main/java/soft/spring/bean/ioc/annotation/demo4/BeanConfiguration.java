package soft.spring.bean.ioc.annotation.demo4;

import lombok.Data;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author : zhayh
 * @date : 2020-3-13 20:53
 * @description :
 */

@Configuration
public class BeanConfiguration {

    @Bean
    //通过该注解设定Bean注入的优先级，不一定连续数字(Spring 4.2及以上版本)
    @Order(15)
    public String string1(){
        return "String-1";
    }

    @Bean
    public List<String> strList() {
        List<String> list = new ArrayList<>();
        list.add("list-1");
        list.add("list-2");
        list.add("list-3");
        list.add("list-4");
        return list;
    }

    @Bean
    @Order(4)
    public String string2(){
        return "String-2";
    }

    @Bean("map")
    public Map<String,Integer> intMap(){
        Map<String,Integer> integerMap = new HashMap<>();
        integerMap.put("map-1",1);
        integerMap.put("map-2",2);
        return integerMap;
    }

    @Bean
    public Integer int1(){
        return 1;
    }

    @Bean
    public Integer int2(){
        return 2;
    }
}
