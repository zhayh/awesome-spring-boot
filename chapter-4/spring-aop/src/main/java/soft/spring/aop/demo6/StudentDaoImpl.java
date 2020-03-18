package soft.spring.aop.demo6;

/**
 * @author : zhayh
 * @date : 2020-2-11 12:24
 * @description :
 */
public class StudentDaoImpl implements StudentDao {
    @Override
    public void find() {
        System.out.println("学生查询......");
    }
    @Override
    public void save() {
        System.out.println("学生保存......");
    }
    @Override
    public void update() {
        System.out.println("学生更新......");
    }
    @Override
    public void delete() {
        System.out.println("学生删除......");
    }
}
