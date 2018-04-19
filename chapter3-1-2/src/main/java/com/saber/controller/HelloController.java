package com.saber.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by sheng on 2018/4/19.
 */
@Controller
public class HelloController {

    @RequestMapping("/index")
    public String index(ModelMap modelMap) {
        modelMap.addAttribute("host", "https://www.baidu.com/");
        return "index";
    }
}
