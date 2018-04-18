package com.saber.controller;

import com.saber.entity.User;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * Created by Administrator on 2018/4/18.
 */
@RestController
@RequestMapping("/users")
public class UserController {

    static Map<Long, User> userMap = Collections.synchronizedMap(new HashMap<>());

    // 处理get请求
    @GetMapping
    public List<User> getUserList() {
        List<User> result = new ArrayList<>(userMap.values());
        return result;
    }

    // 处理post请求
    @PostMapping
    public String addUser(@ModelAttribute User user) {
        userMap.put(user.getId(), user);
        return "success";
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable("id") Long id) {
        return userMap.get(id);
    }

    @PutMapping("/{id}")
    public String putUser(@PathVariable("id") Long id, @ModelAttribute User user) {
        User u = userMap.get(id);
        u.setAge(user.getAge());
        u.setName(user.getName());
        userMap.put(id, u);
        return "success";
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        userMap.remove(id);
        return "success";
    }
}
