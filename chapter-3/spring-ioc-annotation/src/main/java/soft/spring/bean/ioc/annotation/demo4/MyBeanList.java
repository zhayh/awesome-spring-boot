package soft.spring.bean.ioc.annotation.demo4;

import lombok.Data;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author : zhayh
 * @date : 2020-3-13 21:23
 * @description : List注入Bean
 */

@Data
@Component
public class MyBeanList {
    @Autowired
    private List<String> strList;
}
