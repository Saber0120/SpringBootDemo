package com.saber.controller;

import com.saber.config.UserConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by sheng on 2018/4/17.
 */
@RestController
public class HelloController {

    @Value("${server.port}")
    private String port;

    @RequestMapping("/hello")
    public String index() {
        return port;
    }
}
