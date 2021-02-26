package com.example.spring.bean.config;

import com.example.spring.bean.instance.DemoBean;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author : zhayh
 * @date : 2021-2-26 14:37
 * @description :
 */

public class TestBean {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(JavaConfig.class);
        DemoBean bean1 = (DemoBean) context.getBean("demoBean");
        System.out.println(bean1 + bean1.getMessage());

        DemoBean bean2 = (DemoBean) context.getBean("demoBeanStaticFactory");
        System.out.println(bean2 + bean2.getMessage());

        DemoBean bean3 = (DemoBean) context.getBean("demoBeanInstanceFactory");
        System.out.println(bean3 + bean3.getMessage());
    }
}
