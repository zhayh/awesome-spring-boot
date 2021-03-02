package com.example.spring.json;

import com.example.spring.json.article.Article;
import com.example.spring.json.article.Reader;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author : zhayh
 * @date : 2021-3-2 14:31
 * @description :
 */

public class JacksonTest {
    @Test
    public void testSerialization() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        List<Reader> readers = new ArrayList<>(){{
           add(new Reader("张三", 20));
           add(new Reader("李四", 19));
        }};
        Article article = Article.builder()
                .id(1L)
                .author("niit")
                .content("Sprint Boot Restful 接口")
                .createTime(new Date())
                .title("Spring Boot入门")
                .readers(readers)
                .build();
        String json = mapper.writeValueAsString(article);
        System.out.println(json);

        Article article1 = mapper.readValue("{\"id\":1,\"author\":\"niit\",\"title\":" +
                "\"Spring Boot入门\",\"content\":\"Sprint Boot Restful 接口\"," +
                "\"createTime\":1614667117404,\"readers\":[{\"name\":\"张三\",\"age\":20}," +
                "{\"name\":\"李四\",\"age\":19}]}", Article.class);
        System.out.println(article1);
    }
}
