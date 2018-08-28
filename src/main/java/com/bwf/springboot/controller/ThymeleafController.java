package com.bwf.springboot.controller;

import com.bwf.springboot.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("th")
public class ThymeleafController {

    private static final Logger logger =
            LoggerFactory.getLogger(ThymeleafController.class);

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
        user.setUsername("Anderson");
        user.setPassword("123456");
        user.setAge(18);
        user.setDesc("<span style='color:red'>hello</span>");
        user.setBirthday(new Date());

        modelMap.addAttribute("user", user);

        User user1 = new User();
        user1.setUsername("Jack");
        user1.setAge(21);

        User user2 = new User();
        user2.setUsername("Wang");
        user2.setAge(53);

        List<User> userList = new ArrayList<User>();
        userList.add(user);
        userList.add(user1);
        userList.add(user2);

        modelMap.addAttribute("userList", userList);

        return "thymeleaf/test";
    }

    @PostMapping("postform")
    public String postForm(User user) {
        logger.warn("传入的用户信息：{}", user);
        return "redirect:/th/test";
    }
}
