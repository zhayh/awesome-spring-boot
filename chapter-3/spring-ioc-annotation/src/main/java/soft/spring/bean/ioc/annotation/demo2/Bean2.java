package soft.spring.bean.ioc.annotation.demo2;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author : zhayh
 * @date : 2020-2-10 17:14
 * @description :
 */

@Component("bean2")
@Scope("prototype")
public class Bean2 {
}

