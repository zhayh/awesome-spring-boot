package com.example.spring.aspectj;

import com.example.spring.aspectj.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringAspectjApplication implements CommandLineRunner {
    @Autowired
    private UserDao userDao;

    public static void main(String[] args) {
        SpringApplication.run(SpringAspectjApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        userDao.save();
        System.out.println("=====================");
        userDao.modify();
        System.out.println("=====================");
        userDao.delete();
    }
}
