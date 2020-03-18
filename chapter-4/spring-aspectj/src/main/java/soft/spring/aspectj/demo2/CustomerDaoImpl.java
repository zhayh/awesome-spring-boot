package soft.spring.aspectj.demo2;

import org.springframework.stereotype.Repository;

/**
 * @author : zhayh
 * @date : 2020-2-12 08:36
 * @description :
 */

@Repository
public class CustomerDaoImpl implements CustomerDao {
    @Override
    public void save() {
        System.out.println("保存客户......");
    }

    @Override
    public String update() {
        System.out.println("更新客户......");
        return "后置通知可以获取";
    }

    @Override
    public void delete() {
        System.out.println("删除客户......");
    }

    @Override
    public void findOne() {
        System.out.println("查询一个客户......");
    }

    @Override
    public void findAll() {
        System.out.println("查询所有客户......");
    }
}
