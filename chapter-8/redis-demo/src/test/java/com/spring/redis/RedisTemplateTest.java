package com.spring.redis;

import com.spring.redis.model.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.*;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * @author : zhayh
 * @date : 2020-4-19 10:14
 * @description : RedisTemplate的简单使用的测试
 */
@Slf4j
@SpringBootTest
public class RedisTemplateTest {
    @Autowired
    private RedisTemplate redisTemplate;

    // 测试 String
    @Test
    public void testString() {
        ValueOperations<String, String> ops = redisTemplate.opsForValue();
        ops.set("username", "niit");
        Assertions.assertEquals("niit", ops.get("username"));
    }

    // 测试对象
    @Test
    public void testObj() {
        User user = new User("niit@126.com", "smile", 20);
        ValueOperations<String, User> ops = redisTemplate.opsForValue();
        ops.set("com.niit", user);
        User savedUser = ops.get("com.niit");
        log.info("user: {}", savedUser != null ? savedUser.toString() : "没有此用户");
    }

    // 测试超时失效
    @Test
    public void testExpire() throws InterruptedException {
        User user = new User("niit@126.com", "smile", 20);
        ValueOperations<String, User> ops = redisTemplate.opsForValue();
        ops.set("expire", user, 100, TimeUnit.MILLISECONDS);
        Thread.sleep(1000);
        boolean exists = redisTemplate.hasKey("expire");
        if (exists) {
            log.info("exists is true");
        } else {
            log.info("exists is false");
        }
    }

    // 删除数据
    @Test
    public void testDelete() {
        ValueOperations<String, String> ops = redisTemplate.opsForValue();
        ops.set("deletekey", "computer");
        redisTemplate.delete("deletekey");
        boolean exists = redisTemplate.hasKey("computer");
        if (exists) {
            log.info("exists is true");
        } else {
            log.info("exists is false");
        }
    }

    // 测试 Hash
    @Test
    public void testHash() {
        HashOperations<String, Object, Object> hash = redisTemplate.opsForHash();
        hash.put("hash", "you", "you");
        String value = (String) hash.get("hash", "you");
        log.info("hash value: {}", value);
    }

    // 测试 List
    @Test
    public void testList() {
        ListOperations<String, String> list = redisTemplate.opsForList();
        list.leftPush("list", "it");
        list.leftPush("list", "you");
        list.leftPush("list", "know");
        String value = list.leftPop("list");
        log.info("list value: {}", value);

        List<String> values = list.range("list", 0, 2);
        assert values != null;
        for (String v : values) {
            log.info("list range :{}", v);
        }
    }

    // 测试 Set
    @Test
    public void testSet() {
        String key = "set";
        SetOperations<String, String> set = redisTemplate.opsForSet();
        set.add(key, "it");
        set.add(key, "you");
        set.add(key, "you");
        set.add(key, "know");

        Set<String> values = set.members(key);
        assert values != null;
        for (String v : values) {
            log.info("list range :{}", v);
        }
    }

    // 测试 difference(Redis 为集合提供了了求交集、并集、差集等操作)
    @Test
    public void testDifference() {
        SetOperations<String, String> set = redisTemplate.opsForSet();
        String key1 = "setMore1";
        String key2 = "setMore2";
        set.add(key1, "it");
        set.add(key1, "you");
        set.add(key1, "you");
        set.add(key1, "know");
        set.add(key2, "xx");
        set.add(key2, "know");
        Set<String> diffs = set.difference(key1, key2);
        assert diffs != null;
        for (String v : diffs) {
            log.info("diffs set value : {}", v);
        }
    }

    // 测试 unions
    @Test
    public void testUnions() {
        SetOperations<String, String> set = redisTemplate.opsForSet();
        String key3 = "setMore3";
        String key4 = "setMore4";
        set.add(key3, "it");
        set.add(key3, "you");
        set.add(key3, "xx");
        set.add(key4, "aa");
        set.add(key4, "bb");
        set.add(key4, "know");
        Set<String> unions = set.union(key3, key4);
        assert unions != null;
        for (String v : unions) {
            log.info("unions value : {}", v);
        }
    }

    // 测试 Zset
    @Test
    public void testZset() {
        String key = "zset";

        ZSetOperations<String, String> zset = redisTemplate.opsForZSet();
        zset.add(key, "it", 1);
        zset.add(key, "you", 6);
        zset.add(key, "know", 4);
        zset.add(key, "neo", 3);

        Set<String> zsets = zset.range(key, 0, 3);
        assert zsets != null;
        for (String v : zsets) {
            log.info("zset value : {}", v);
        }

        Set<String> zsetB = zset.rangeByScore(key, 0, 3);
        assert zsetB != null;
        for (String v : zsetB) {
            log.info("zsetB value : {}", v);
        }
    }
}
