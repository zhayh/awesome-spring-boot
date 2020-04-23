package com.spring.security.dynamic.model;

import lombok.Data;

import java.util.List;

/**
 * @author : zhayh
 * @date : 2020-4-16 20:03
 * @description :
 */

@Data
public class Menu {
    private Integer id;
    private String pattern;
    private List<Role> roles;
}
