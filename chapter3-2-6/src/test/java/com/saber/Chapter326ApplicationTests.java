package com.saber;

import com.saber.entity.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Chapter326ApplicationTests {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Resource(name = "stringRedisTemplate")
    ValueOperations<String, String> valOpsStr;

    @Autowired
    RedisTemplate<Object, Object> redisTemplate;

    @Resource(name = "redisTemplate")
    ValueOperations<Object, Object> valOpsObj;

    @Test
    public void contextLoads() {
    }

    @Test
    public void testRedis() {
        //保存字符串
        valOpsStr.set("aaa", "111");
        Assert.assertEquals(valOpsStr.get("aaa"), "111");

        User user = new User(1, "Saber", 22);
        valOpsObj.set("user", user);
        User redisUser = (User) valOpsObj.get("user");
        Assert.assertEquals(redisUser.getUsername(), "Saber");
        Assert.assertEquals(redisUser.getAge().intValue(), 22);
    }
}
