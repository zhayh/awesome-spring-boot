package com.spring.redis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : zhayh
 * @date : 2020-4-18 18:29
 * @description :
 */

@RestController
public class HelloController {
    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @GetMapping("/set")
    public void set() {
        ValueOperations<String, String> ops = stringRedisTemplate.opsForValue();
        ops.set("name", "niit");
    }

    @GetMapping("/get")
    public String get() {
        ValueOperations<String, String> ops = stringRedisTemplate.opsForValue();
        return ops.get("name");
    }
}
