package com.saber.controller;

import com.saber.entity.User;
import io.swagger.annotations.ApiOperation;
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
    @ApiOperation(value = "获取用户列表", notes = "获取全部用户列表")
    @GetMapping
    public List<User> getUserList() {
        List<User> result = new ArrayList<>(userMap.values());
        return result;
    }

    // 处理post请求
    @ApiOperation(value = "新增用户", notes = "新增用户，成功返回success")
    @PostMapping
    public String addUser(@ModelAttribute User user) {
        userMap.put(user.getId(), user);
        return "success";
    }

    @ApiOperation(value = "获取用户详情", notes = "根据用户id获取用户详情")
    @GetMapping("/{id}")
    public User getUser(@PathVariable("id") Long id) {
        return userMap.get(id);
    }

    @ApiOperation(value = "更新用户", notes = "更新指定用户id的用户信息")
    @PutMapping("/{id}")
    public String putUser(@PathVariable("id") Long id, @ModelAttribute User user) {
        User u = userMap.get(id);
        u.setAge(user.getAge());
        u.setName(user.getName());
        userMap.put(id, u);
        return "success";
    }

    @ApiOperation(value = "删除用户", notes = "根据用户id删除用户")
    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        userMap.remove(id);
        return "success";
    }
}
