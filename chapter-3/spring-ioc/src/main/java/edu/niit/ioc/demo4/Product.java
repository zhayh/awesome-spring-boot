package edu.niit.ioc.demo4;

/**
 * @author : zhayh
 * @date : 2020-2-10 13:34
 * @description : 商品类
 */
public class Product {
    private String name;
    private double price;
    private Category category;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Double getDiscountPrice() {
        return Math.random() * this.price;
    }
    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", category=" + category +
                '}';
    }
}
