package com.spring.mq.rabbitmq.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author : zhayh
 * @date : 2020-4-24 20:19
 * @description :
 */

@Data
public class Message implements Serializable {
    public static final String MARKET_QUEUE = "marketQueue";
    public static final String FINANCE_QUEUE = "financeQueue";
    public static final String ADMIN_QUEUE = "adminQueue";
    public static final String ALL_QUEUE = "allQueue";

    public static final String DIRECT_EXCHANGE = "direct-exchange";
    public static final String FANOUT_EXCHANGE = "fanout-exchange";
    public static final String TOPIC_EXCHANGE = "topic-exchange";
    public static final String HEADER_EXCHANGE = "header-exchange";

    public static final String MARKET_ROUTING_KEY = "market";
    public static final String FINANCE_ROUTING_KEY = "finance";
    public static final String ADMIN_ROUTING_KEY = "admin";

    private Integer id;
    private String content;
    private Date createDate;
}
