package com.mybatis.generator.enumeration;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * @author : zhayh
 * @date : 2020-4-8 19:28
 * @description :
 */
public enum SexEnum {
    MALE(1, "男"),
    FEMALE(2, "女")
    ;

    private int id;
    private String name;

    SexEnum(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public static SexEnum getEnumById(int id) {
        return Arrays.stream(SexEnum.values())
                .filter(sex -> sex.id == id)
                .collect(Collectors.toList()).get(0);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
