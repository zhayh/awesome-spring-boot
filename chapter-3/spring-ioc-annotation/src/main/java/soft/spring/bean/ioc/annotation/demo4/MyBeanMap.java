package soft.spring.bean.ioc.annotation.demo4;

import lombok.Data;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @author : zhayh
 * @date : 2020-3-13 21:26
 * @description : 通过Map注入Bean
 */
@Data
@Component
public class MyBeanMap {
    @Resource(name = "map")
    private Map<String, Integer> intMap;
}
