package com.spring.restful.pojo;

import lombok.Builder;
import lombok.Data;

/**
 * @author : zhayh
 * @date : 2020-2-18 09:08
 * @description : Message的持久层对象Persisent Object
 */

@Data
public class Message {
    private Long id;
    private String text;
    private String summary;
}
