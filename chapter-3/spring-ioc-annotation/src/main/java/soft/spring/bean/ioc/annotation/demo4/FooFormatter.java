package soft.spring.bean.ioc.annotation.demo4;

import org.springframework.stereotype.Component;

/**
 * @author : zhayh
 * @date : 2020-2-10 17:21
 * @description :
 */

@Component("fooFormatter")
public class FooFormatter {
    public String format() {
        return "foo";
    }
}
