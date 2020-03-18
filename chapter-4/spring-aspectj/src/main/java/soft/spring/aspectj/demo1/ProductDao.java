package soft.spring.aspectj.demo1;

import org.springframework.stereotype.Repository;

/**
 * @author : zhayh
 * @date : 2020-2-11 20:42
 * @description :
 */

@Repository
public class ProductDao {
    public void save() {
        System.out.println("保存商品......");
    }
    public String update() {
        System.out.println("更新商品......");
        return "后置通知可以获取";
    }
    public void delete() {
        System.out.println("删除商品......");
    }
    public void findOne() {
        System.out.println("查询一个商品......");
//        int result = 1 / 0;  // 演示异常抛出通知
    }
    public void findAll() {
        System.out.println("查询所有商品......");
    }
}
