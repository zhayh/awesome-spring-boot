package edu.niit.ioc.demo4;

/**
 * @author : zhayh
 * @date : 2020-2-10 12:19
 * @description :
 */
public class Cat {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                '}';
    }


}
