package com.mybatis.generator.mapper;

import com.mybatis.generator.mapper.generator.UsersMapper;
import com.mybatis.generator.model.generator.Message;
import com.mybatis.generator.model.generator.MessageExample;
import com.mybatis.generator.model.generator.Users;
import com.mybatis.generator.model.generator.UsersExample;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author : zhayh
 * @date : 2020-4-9 11:26
 * @description :
 */

@Slf4j
@SpringBootTest
public class UsersMapperTest {
    @Resource
    private UsersMapper usersMapper;

    @Test
    public void testInsert() {
        Users users = new Users().withUserName("李四").withSex(1).withNote("希望学校早点开学");
        int num = usersMapper.insertSelective(users);
        log.info("插入的记录数：{}", num);
    }

    @Test
    @Order(2)
    public void testSelectAll() {
        // select * from users
        usersMapper.selectByExample(null).forEach(
                user -> log.info("查询的数据： {}", user.toString()));
    }

    @Test
    @Order(4)
    public void testUpdate() {
        // update users set user_name = #{userName}, sex = #{sex} where id = #{id}
        Users users = new Users().withId(1L).withUserName("computer").withSex(1);
        int num = usersMapper.updateByPrimaryKey(users);
        log.info("更新的数据条数： {}", num);
    }

    @Test
    @Order(5)
    public void testUpdateName() {
        // update users set user_name = #{userName} where id = #{id}
        Users user = new Users().withUserName("computer");
        UsersExample usersExample = new UsersExample();
        usersExample.createCriteria().andIdEqualTo(1L);
        int num = usersMapper.updateByExampleSelective(user, usersExample);
        log.info("更新Text的数据条数： {}", num);
    }

    @Test
    @Order(6)
    public void testSelectById() {
        // select * from users where id = #{id}
        UsersExample usersExample = new UsersExample();
        usersExample.createCriteria().andIdEqualTo(8L);
        List<Users> users = usersMapper.selectByExample(usersExample);
        Users user = users != null && !users.isEmpty() ? users.get(0) : null;
        log.info("id为8的数据： {}", user);
    }

    @Test
    @Order(7)
    public void testFindByCondition() {
        // select * from users where note like #{note}
        UsersExample usersExample = new UsersExample();
        usersExample.createCriteria().andNoteLike("学校");
        List<Users> users = usersMapper.selectByExample(usersExample);
        log.info("note中包含学校的记录有： {}", users != null ? users.size() : 0);
    }
    @Test
    @Order(8)
    public void testDelete() {
        // delete from users where id = #{id}
        UsersExample usersExample = new UsersExample();
        usersExample.createCriteria().andUserNameEqualTo("niit");
        int num = usersMapper.deleteByExample(usersExample);
        log.info("删除的数据条数： {}", num);
    }
}
