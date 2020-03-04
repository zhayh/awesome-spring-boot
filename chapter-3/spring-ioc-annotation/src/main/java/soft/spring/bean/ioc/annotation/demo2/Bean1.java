package soft.spring.bean.ioc.annotation.demo2;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @author : zhayh
 * @date : 2020-2-10 16:30
 * @description :
 */

@Component
public class Bean1 {
    @PostConstruct
    public void init() {
        System.out.println("init bean......");
    }
    public void say() {
        System.out.println("say......");
    }
    @PreDestroy
    public void destory() {
        System.out.println("destroy bean......");
    }
}
