package com.spring.mq.rabbitmq.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author : zhayh
 * @date : 2020-4-25 13:25
 * @description :
 */
@Data
public class HeaderMessage implements Serializable {
    // header exchange
    public static final String HEADER_KEY = "department";
    public static final String ADMIN_HEADER_VALUE = "admin";
    public static final String FINANCE_HEADER_VALUE = "finance";
    public static final String MARKET_HEADER_VALUE = "marketing";

    private Integer id;
    private String content;
    private Date createDate;
}
