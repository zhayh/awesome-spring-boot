package com.example.spring.json.article;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

/**
 * @author : zhayh
 * @date : 2021-2-27 21:12
 * @description :
 */

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
//@JsonPropertyOrder(value = {"content", "title"})
//@JsonInclude(JsonInclude.Include.NON_NULL)
public class Article {
    private Long id;

//    @JsonProperty("author")
    private String author;
    private String title;
    private String content;

//    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;
    private List<Reader> readers;
}
