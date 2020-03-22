package com.spring.restful.custom.pojo;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.util.Date;

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
    @JSONField(format = "yyyy-MM-dd hh:mm:dd")
    private Date createTime;
}


/*
fastjson的Date数据格式： 2020-03-21T13:31:34.268+0000
 */
