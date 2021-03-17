package com.example.spring.execise.service.dto;

import lombok.Builder;
import lombok.Data;

/**
 * @author : zhayh
 * @date : 2021-3-13 16:10
 * @description : 班级对象
 */

@Data
@Builder
public class BaseClassInfo {
    private String classCode;
    private String className;
    private Integer classYear;
}
