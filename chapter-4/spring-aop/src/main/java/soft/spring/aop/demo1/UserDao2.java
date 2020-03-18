package soft.spring.aop.demo1;

/**
 * @author : zhayh
 * @date : 2020-2-11 09:55
 * @description : UseDao实现类
 */
public class UserDao2 {
    /** 保存用户 */
    public void save() {
        System.out.println("保存用户......");
    }
    /** 修改用户 */
    public void update() {
        System.out.println("修改用户......");
    }
    /** 删除用户 */
    public void delete() {
        System.out.println("删除用户......");
    }
    /** 查询用户 */
    public void find() {
        System.out.println("查询用户......");
    }
}
