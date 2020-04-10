package com.spring.jpa.mysql.model.cascade;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Authority {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String name; //权限名

    @ManyToMany(mappedBy = "authorityList")
    private List<User> userList;
}
