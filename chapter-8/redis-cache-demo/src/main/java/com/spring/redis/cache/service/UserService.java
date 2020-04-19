package com.spring.redis.cache.service;

import com.spring.redis.cache.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;

/**
 * @author : zhayh
 * @date : 2020-4-19 14:12
 * @description :
 */
@Slf4j
@Service
@CacheConfig(cacheNames = "c1")
public class UserService {
    @Cacheable
    public User getUserById(Integer id) {
        log.info("getUserById >>> {}", id);
        User user = new User();
        user.setId(id);
        return user;
    }

    // 删除数据库记录的同时，也把缓存中的记录也删除
    @CacheEvict(beforeInvocation = true)
    public void deleteUserById(Integer id) {
        log.info("deleteUserById >>> {}", id);
    }

    @CachePut(key = "#user.id")
    public void updateUserById(User user) {
        log.info("updateUserById >>> {}", user.getId());
    }
}
