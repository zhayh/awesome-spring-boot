package com.example.spring.json.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author : zhayh
 * @date : 2021-2-27 21:14
 * @description :
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Reader {
    private String name;
    private Integer age;
}
