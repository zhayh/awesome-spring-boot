package com.spring.redis.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author : zhayh
 * @date : 2020-4-19 10:19
 * @description :
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {
    private String username;
    private String nickname;
    private Integer age;
}
