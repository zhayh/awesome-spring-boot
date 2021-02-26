package edu.niit.props.controller;

import edu.niit.props.config.DBConnector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : zhayh
 * @date : 2020-3-10 21:09
 * @description :
 */
@RestController
public class DBController  {
    @Autowired
    private DBConnector dbConnector;

    @GetMapping("/showDB")
    public void show() {
        dbConnector.configure();
    }
}
