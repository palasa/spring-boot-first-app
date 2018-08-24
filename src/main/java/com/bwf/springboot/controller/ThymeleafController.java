package com.bwf.springboot.controller;

import com.bwf.springboot.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

@Controller
@RequestMapping("th")
public class ThymeleafController {

    @RequestMapping("index")
    public String index(ModelMap modelMap) {
        modelMap.addAttribute("name", "thymeleaf test");
        return "thymeleaf/index";
    }

    @RequestMapping("center")
    public String center() {
        return "thymeleaf/center/center";
    }

    @RequestMapping("test")
    public String test(ModelMap modelMap) {
        User user = new User();
        user.setUsername("张三");
        user.setPassword("123456");
        user.setAge(18);
        user.setDesc("<span style='color:red'>hello</span>");
        user.setBirthday(new Date());

        modelMap.addAttribute("user", user);
        return "thymeleaf/test";
    }
}