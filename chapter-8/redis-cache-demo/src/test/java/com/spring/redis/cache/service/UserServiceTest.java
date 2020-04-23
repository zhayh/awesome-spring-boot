package com.spring.redis.cache.service;

import com.spring.redis.cache.model.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author : zhayh
 * @date : 2020-4-19 14:25
 * @description :
 */
@Slf4j
@SpringBootTest
public class UserServiceTest {
    @Autowired
    UserService userService;

    @Test
    public void testGetUser() {
        User user1 = userService.getUserById(1);
        User user2 = userService.getUserById(1);
        log.info(user1.toString());
        log.info(user2.toString());
    }

    @Test
    public void testUpdateUser() {
        User user1 = userService.getUserById(1);
        User user = new User();
        user.setId(1);
        user.setUsername("niit");
        user.setAddress("xianlin");
        userService.updateUserById(user);
        User user2 = userService.getUserById(1);

        log.info(user1.toString());
        log.info(user2.toString());
    }

    @Test
    public void testDeleteUser() {
        User user1 = userService.getUserById(1);
        userService.deleteUserById(1);
        User user2 = userService.getUserById(1);

        log.info(user1.toString());
        log.info(user2.toString());
    }
}
