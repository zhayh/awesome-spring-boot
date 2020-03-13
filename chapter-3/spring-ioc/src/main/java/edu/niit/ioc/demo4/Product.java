package edu.niit.ioc.demo4;

import lombok.Data;

/**
 * @author : zhayh
 * @date : 2020-2-10 13:34
 * @description : 商品类
 */
@Data
public class Product {
    private String name;
    private double price;
    private Category category;
}
