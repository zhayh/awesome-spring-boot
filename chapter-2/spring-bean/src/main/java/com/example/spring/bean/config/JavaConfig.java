package com.example.spring.bean.config;

import com.example.spring.bean.DemoBean;
import com.example.spring.bean.DemoBeanInstanceFactory;
import com.example.spring.bean.DemoBeanStaticFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author : zhayh
 * @date : 2021-2-26 14:34
 * @description :
 */

@Configuration
public class JavaConfig {
    /**
     * 构造方法实例化
     * @return
     */
    @Bean(value = "demoBean")
    public DemoBean getDemoBean() {
        return new DemoBean();
    }
    /**
     * 构造方法实例化
     * @return
     */
    @Bean(value = "demoBeanStaticFactory")
    public DemoBean getDemoBeanStaticFactory() {
        return DemoBeanStaticFactory.createInstance();
    }
    /**
     * 构造方法实例化
     * @return
     */
    @Bean(value = "demoBeanInstanceFactory")
    public DemoBean getDemoBeanInstanceFactory() {
        return new DemoBeanInstanceFactory().createDemoBeanInstance();
    }
}
