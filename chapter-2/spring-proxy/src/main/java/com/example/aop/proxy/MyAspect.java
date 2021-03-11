package com.example.aop.proxy;

/**
 * @author : zhayh
 * @date : 2021-3-9 16:08
 * @description :
 */

public class MyAspect {
    public void checkPermissions() {
        System.out.println("模拟检查权限......");
    }

    public void log() {
        System.out.println("模拟记录日志......");
    }
}
