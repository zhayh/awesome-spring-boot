package com.example.lombok.model;


import lombok.Builder;
import lombok.Data;
import lombok.Value;

@Data
@Builder
public class Student {
    private String StuNo;
    private String name;
}
