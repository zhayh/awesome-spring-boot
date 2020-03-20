package com.spring.api.swagger.pojo;

import io.swagger.annotations.ApiModel;
import lombok.Builder;
import lombok.Data;

/**
 * @author : zhayh
 * @date : 2020-2-18 09:08
 * @description : Message的持久层对象Persisent Object
 */

@Data
@ApiModel(value = "消息对象")
public class Message {
    private Long id;
    private String text;
    private String summary;
}
