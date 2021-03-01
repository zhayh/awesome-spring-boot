package com.example.spring.restful.model;

import com.fasterxml.jackson.annotation.*;
import lombok.Builder;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @author : zhayh
 * @date : 2021-2-27 21:12
 * @description :
 */

@Data
@Builder
@JsonPropertyOrder(value = {"content", "title"})
public class Article {
    @JsonIgnore
    private Long id;

    @JsonProperty("author")
    private String author;
    private String title;
    private String content;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;
    private List<Reader> readers;
}

/*
post请求的数据格式
{
    "content": "Sprint Boot Restful 接口",
    "title": "Spring Boot入门",
    "createTime": "2021-02-27T22:00:22Z",
    "readers": null,
    "author": "niit"
}
 */
