package com.example.spring.exception.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

/**
 * @author : zhayh
 * @date : 2021-3-14 20:52
 * @description : 文章类
 */

@Data
public class Article {
    private Long id;

    @NotNull(message = "作者信息不能为空")
    @JsonProperty("author")
    private String author;
    private String title;

    @NotEmpty(message = "文章内容不能为空")
    private String content;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;

    private List<Reader> readers;
}
