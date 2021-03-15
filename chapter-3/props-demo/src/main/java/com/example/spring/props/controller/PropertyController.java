package com.example.spring.props.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : zhayh
 * @date : 2021-2-27 18:42
 * @description : 读取test.properties配置文件中的属性
 */

@RestController
@PropertySource({"classpath:test.properties"})
public class PropertyController {
    private Log log = LogFactory.getLog(PropertyController.class);

    @Value("${my.msg}")
    private String myMsg;

    @RequestMapping("/testProperty")
    public String test() {
        log.debug("测试debug日志");
        log.info("测试info日志");
        return "其它配置文件: " + myMsg;
    }
}
