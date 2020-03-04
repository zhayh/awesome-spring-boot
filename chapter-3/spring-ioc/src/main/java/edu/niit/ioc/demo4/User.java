package edu.niit.ioc.demo4;

/**
 * @author : zhayh
 * @date : 2020-2-10 12:06
 * @description : 用户类
 */
public class User {
    private String name;
    private Integer age;
    public User(String name, Integer age) {
        this.name = name;
        this.age = age;
    }
    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
