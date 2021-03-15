package com.example.spring.props.controller;

import com.example.spring.props.config.DBConnector;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author : zhayh
 * @date : 2020-3-10 21:09
 * @description :
 */
@RestController
public class DBController {
    @Resource
    private DBConnector dbConnector;

    @GetMapping("/showDB")
    public void show() {
        dbConnector.configure();
    }
}
