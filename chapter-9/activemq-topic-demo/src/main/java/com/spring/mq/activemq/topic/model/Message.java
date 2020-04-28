package com.spring.mq.activemq.topic.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author : zhayh
 * @date : 2020-4-24 13:25
 * @description :
 */

@Data
public class Message implements Serializable {
    private Integer id;
    private String content;
    private Date sendDate;
}
