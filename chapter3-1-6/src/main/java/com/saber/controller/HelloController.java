package com.saber.controller;

import com.saber.exception.MyException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by sheng on 2018/4/19.
 */
@RestController
public class HelloController {

    @RequestMapping("/hello")
    public String hello() throws Exception {
        throw new Exception("发生错误");
    }

    @RequestMapping("/json")
    public String json() throws Exception {
        throw new MyException("Some error");
    }
}
