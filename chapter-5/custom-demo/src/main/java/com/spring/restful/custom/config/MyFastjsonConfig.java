package com.spring.restful.custom.config;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;

import java.util.Arrays;

/**
 * @author : zhayh
 * @date : 2020-3-21 17:18
 * @description : FastJSON转换器
 * SerializerFeature参考：http://kimmking.github.io/2017/06/06/json-best-practice/
 */
@Configuration
public class MyFastjsonConfig {
    @Bean
    FastJsonHttpMessageConverter fastJsonHttpMessageConverter() {
        FastJsonHttpMessageConverter converter = new FastJsonHttpMessageConverter();
        FastJsonConfig config = new FastJsonConfig();
        config.setDateFormat("yyyy-MM-dd hh:mm:ss");    // 全局日期格式修改
        config.setSerializerFeatures(
                SerializerFeature.PrettyFormat,            // 输出内容格式化
                SerializerFeature.WriteClassName,          // 序列化时写入类型信息. 反序列化时会用到
                SerializerFeature.WriteMapNullValue,       // 输出值为null的字段,默认为false
                SerializerFeature.WriteNullListAsEmpty,    // 将Collection类型字段的字段空值输出为[]
                SerializerFeature.WriteNullStringAsEmpty,  // 将字符串类型字段的空值输出为空字符串
                SerializerFeature.DisableCircularReferenceDetect // 禁用循环依赖
        );
        converter.setSupportedMediaTypes(Arrays.asList(MediaType.APPLICATION_JSON));
        converter.setFastJsonConfig(config);
        return converter;
    }
}
