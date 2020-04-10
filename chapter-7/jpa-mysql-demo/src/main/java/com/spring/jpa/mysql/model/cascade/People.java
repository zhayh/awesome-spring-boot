package com.spring.jpa.mysql.model.cascade;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@Entity
public class People {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;//id

    @Column(name = "name", nullable = true, length = 20)
    private String name;//姓名

    @Column(name = "sex", nullable = true, length = 1)
    private String sex;//性别

    @Column(name = "birthday", nullable = true)
    private Timestamp birthday;//出生日期

    // People是关系的维护端，当删除 people，会级联删除 address
    // people中的address_id字段参考address表中的id字段
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private Address address;//地址
}
