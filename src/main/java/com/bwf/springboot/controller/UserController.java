package com.bwf.springboot.controller;


import com.bwf.springboot.entity.User;
import com.bwf.springboot.service.IUserService;
import com.bwf.springboot.entity.JsonResult;
import com.bwf.springboot.utils.JsonResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    private final IUserService userService;

    @Autowired
    public UserController(IUserService userService) {
        this.userService = userService;
    }

    @GetMapping("/user/{id}")
    public JsonResult getUser(@PathVariable Integer id) {
        return JsonResultUtil.success(userService.getUser(id));
    }

    @GetMapping("/user")
    public JsonResult userList() {
        return JsonResultUtil.success(userService.userList());
    }

    @PostMapping("/user")
    public JsonResult userAdd(User user) {
        return JsonResultUtil.success(userService.userAdd(user));
    }

    @DeleteMapping("/user/{id}")
    public JsonResult userDelete(@PathVariable Integer id) {
        userService.userDelete(id);
        return JsonResultUtil.success(null);
    }

    @PutMapping("/user")
    public JsonResult userEdit(User user) {
        logger.debug("【用户信息】：", user.toString());
        return JsonResultUtil.success(userService.userEdit(user));
    }

}
