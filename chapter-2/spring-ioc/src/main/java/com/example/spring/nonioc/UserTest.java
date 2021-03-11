package com.example.spring.nonioc;

/**
 * @author : zhayh
 * @date : 2021-3-9 11:20
 * @description :
 */

public class UserTest {
    public static void main(String[] args) {
        UserService service = new UserServiceImpl();
        service.setUserDao(new UserDaoImpl());
        service.save();
    }
}
