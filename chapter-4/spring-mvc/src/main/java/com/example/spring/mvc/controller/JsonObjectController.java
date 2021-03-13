package com.example.spring.mvc.controller;

import com.example.spring.mvc.dto.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author : zhayh
 * @date : 2021-2-27 18:30
 * @description :
 */

@Slf4j
@RestController
@RequestMapping("/api")
public class JsonObjectController {
    @RequestMapping(value = "/helloworld", method = RequestMethod.GET)
    public ResponseEntity<String> hello() {
        return ResponseEntity.ok("Hello world.");
    }

    // 参数传递
    @PostMapping(value = "/user")
    public User doJsonParam(@RequestBody User user) {
        log.info(user.toString());
        return user;
    }

    @GetMapping(value = "/user/{name}/{age}")
    public String findUser(@PathVariable(value = "age") Integer age,
                           @PathVariable(value = "name") String name) {
        String content = String.format("name = %s,age = %d", name, age);
        log.info(content);
        return content;
    }
}
