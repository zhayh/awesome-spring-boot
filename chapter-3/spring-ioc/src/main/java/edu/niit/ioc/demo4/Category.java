package edu.niit.ioc.demo4;

/**
 * @author : zhayh
 * @date : 2020-2-10 13:34
 * @description : 商品类别
 */
public class Category {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Category{" +
                "name='" + name + '\'' +
                '}';
    }
}
