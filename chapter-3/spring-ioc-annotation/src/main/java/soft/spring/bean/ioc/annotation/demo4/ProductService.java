package soft.spring.bean.ioc.annotation.demo4;

import org.springframework.beans.factory.annotation.Autowired;
import soft.spring.bean.ioc.annotation.demo3.CustomDao;

/**
 * @author : zhayh
 * @date : 2020-2-10 17:20
 * @description :
 */

public class ProductService {
    @Autowired
    private CategoryDao categoryDao;
    @Autowired
    private CustomDao productDao;

    public void save() {
        System.out.println("ProductService的save()执行了......");
        categoryDao.save();
        productDao.save();
    }
}
