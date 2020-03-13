package edu.niit.ioc.demo4;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

/**
 * @author : zhayh
 * @date : 2020-2-10 12:06
 * @description : 用户类
 */

@Data
@AllArgsConstructor
public class User {
    private String name;
    private Integer age;
}
