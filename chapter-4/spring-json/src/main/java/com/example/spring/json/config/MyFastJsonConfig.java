package com.example.spring.json.config;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;

import java.nio.charset.StandardCharsets;
import java.util.Collections;

/**
 * @author : zhayh
 * @date : 2021-3-2 09:51
 * @description :
 */

//@Configuration
public class MyFastJsonConfig {
    /**
     * 配置HttpMessageConverters使用Fastjson实现JSON转换
     */
    @Bean
    public FastJsonHttpMessageConverter fastJsonConverters() {
        FastJsonHttpMessageConverter converter = new FastJsonHttpMessageConverter();
        FastJsonConfig config = new FastJsonConfig();
        config.setDateFormat("yyyy-MM-dd");
        config.setCharset(StandardCharsets.UTF_8);
        config.setSerializerFeatures(
//                SerializerFeature.WriteClassName,           // 序列化写入类型信息
                SerializerFeature.WriteMapNullValue,        // null值的默认值为false
                SerializerFeature.PrettyFormat,             // 格式化输出内容
                SerializerFeature.WriteNullListAsEmpty,     // Collection类型的空值输出为空值
                SerializerFeature.WriteNullStringAsEmpty,   // 字符串空值输出为空字符串
                SerializerFeature.DisableCircularReferenceDetect    // 禁用循环依赖
        );
        converter.setSupportedMediaTypes(Collections.singletonList(MediaType.APPLICATION_JSON));
        converter.setFastJsonConfig(config);
        return converter;
    }
}
