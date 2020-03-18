package soft.spring.aop.demo2;

/**
 * @author : zhayh
 * @Date : 2020-2-11 09:53
 * @Description:
 */
public class ProductDao {
    // 保存用户
    public void save() {
        System.out.println("保存商品......");
    }
    // 修改用户
    public void update() {
        System.out.println("修改商品......");
    }
    // 删除用户
    public void delete() {
        System.out.println("删除商品......");
    }
    // 查询用户
    public void find() {
        System.out.println("查询商品......");
    }
}
