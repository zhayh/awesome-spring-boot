package com.example.spring.json.config;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.GsonHttpMessageConverter;

import java.lang.reflect.Modifier;

/**
 * @author : zhayh
 * @date : 2021-3-2 08:47
 * @description :
 */

@Configuration
public class GsonConfig {
    @Bean
    public GsonHttpMessageConverter gsonConverters() {
        GsonHttpMessageConverter converter = new GsonHttpMessageConverter();
        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd")
                .excludeFieldsWithModifiers(Modifier.PROTECTED)
                .disableHtmlEscaping()
                .create();
        converter.setGson(gson);
        return converter;
    }
}
