package edu.niit.props.model;

import lombok.Data;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * @author : zhayh
 * @date : 2020-2-28 17:08
 * @description :
 */
@Data
@ToString
@Component
@ConfigurationProperties(prefix = "book")
public class Book {
//    @Value("${book.name}")
    private String name;
    private String author;
    private Float price;
    private String description;
    // 粉丝列表
    private List<String> fans;
    // 每月排名
    private Map<String, Integer> rank;
}
