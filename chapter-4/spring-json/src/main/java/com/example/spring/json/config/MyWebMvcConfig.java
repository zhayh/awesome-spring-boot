package com.example.spring.json.config;

import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

/**
 * @author : zhayh
 * @date : 2021-3-2 10:25
 * @description :
 */

//@Configuration
public class MyWebMvcConfig implements WebMvcConfigurer {
    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
//        FastJsonHttpMessageConverter converter = new FastJsonHttpMessageConverter();
//        FastJsonConfig config = new FastJsonConfig();
//        config.setDateFormat("yyyy-MM-dd");
//        config.setCharset(StandardCharsets.UTF_8);
//        config.setSerializerFeatures(
////                SerializerFeature.WriteClassName,           // 序列化写入类型信息
//                SerializerFeature.WriteMapNullValue,        // null值的默认值为false
//                SerializerFeature.PrettyFormat,             // 格式化输出内容
//                SerializerFeature.WriteNullListAsEmpty,     // Collection类型的空值输出为空值
//                SerializerFeature.WriteNullStringAsEmpty,   // 字符串空值输出为空字符串
//                SerializerFeature.DisableCircularReferenceDetect    // 禁用循环依赖
//        );
//        converter.setSupportedMediaTypes(Collections.singletonList(MediaType.APPLICATION_JSON));
//        converter.setFastJsonConfig(config);
//        converters.add(0, converter);  //将fastJsonConverter排在转换器列表的首位
    }
}
