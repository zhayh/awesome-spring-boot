package com.example.lombok.model;

import lombok.*;
import org.springframework.stereotype.Component;

@Setter
@Getter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Component
public class Person {
    private String name;
    private int age;
}
