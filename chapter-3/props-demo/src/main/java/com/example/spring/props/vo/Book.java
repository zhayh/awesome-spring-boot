package com.example.spring.props.vo;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * @author : zhayh
 * @date : 2020-2-28 17:08
 * @description : 普通的属性注入
 */
//@Data
//@Component
//public class Book {
//    @Value("${book.name}")
//    private String name;
//    @Value("${book.author}")
//    private String author;
//    @Value("${book.price}")
//    private Float price;
//    @Value("${book.description}")
//    private String description;
//    // 粉丝列表
//    private List<String> fans;
//    // 每月排名
//    private Map<String, Integer> rank;
//}

// 类型安全的属性注入
@Data
@Component
@ConfigurationProperties(prefix = "book")
public class Book {
    private String name;
    private String author;
    private Float price;
    private String description;
    // 粉丝列表
    private List<String> fans;
    // 每月排名
    private Map<String, Integer> rank;
}
