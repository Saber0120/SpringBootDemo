package com.saber.controller;

import com.google.common.collect.Lists;
import com.saber.entity.User;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2018/4/22.
 */
@RestController
public class UserController {

    private static Map<Integer, User> map = new HashMap<>();

//    @Cacheable(value = "testCache")
//    @GetMapping("/{id}")
//    public User testCaching(@PathVariable("id") Integer id) {
//        System.out.println("no cache");
//        return new User(id,"saber", id + 20);
//    }

    @CachePut(value = "user", key = "#root.caches[0].name + ':' + #user.id")
    @PostMapping("/")
    public User add(User user) {
        map.put(user.getId(), user);
        return user;
    }

    @CachePut(value = "user", key = "#root.caches[0].name + ':' + #user.id")
    @PutMapping("/{id}")
    public User edit(User user, @PathVariable("id") Integer id) {
        map.put(id, user);
        return user;
    }

    @CacheEvict(value = "user")
    @DeleteMapping("/{id}")
    public Integer delete(@PathVariable("id") Integer id) {
        map.remove(id);
        return 1;
    }

    @GetMapping("/")
    @Cacheable(value = "user")
    public List<User> findAll() {
        System.out.println("not from cache:all");
        List<User> userList = Lists.newArrayList();
        for (Map.Entry<Integer,User> userEntry : map.entrySet()) {
            userList.add(userEntry.getValue());
        }
        return userList;
    }

    @GetMapping("/{id}")
    @Cacheable(value = "user")
    public User getById(@PathVariable("id") Integer id) {
        System.out.println("not from cache:" + id);
        return map.get(id);
    }
}
