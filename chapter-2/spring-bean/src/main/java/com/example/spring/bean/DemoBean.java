package com.example.spring.bean;

/**
 * @author : zhayh
 * @date : 2021-2-26 14:29
 * @description :
 */

public class DemoBean {
    private String message;

    public DemoBean() {
        this.message = "构造方法实例化DemoBean";
    }

    public DemoBean(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
