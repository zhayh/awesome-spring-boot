package com.spring.mvc.jsp;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * @author : zhayh
 * @date : 2020-3-20 08:21
 * @description : 获取Servlet的外部支持
 */
public class ServletInitializer extends SpringBootServletInitializer {
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(JspDemoApplication.class);
    }
}
