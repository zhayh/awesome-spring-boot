package com.example.spring.execise.service.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

/**
 * @author : zhayh
 * @date : 2021-3-13 16:12
 * @description : 学生对象
 */
@Data
@Builder
public class StudentDTO {
    private String studentCode;
    private String studentName;
    private BaseClassInfo classInfo;
    private List<StudentDTO> roommates;
}
