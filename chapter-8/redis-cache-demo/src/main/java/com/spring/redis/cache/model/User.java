package com.spring.redis.cache.model;

import lombok.Data;

import java.io.Serializable;

/**
 * @author : zhayh
 * @date : 2020-4-19 14:10
 * @description :
 */
@Data
public class User implements Serializable {
    private Integer id;
    private String username;
    private String address;
}
