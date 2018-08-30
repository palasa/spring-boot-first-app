package com.bwf.springboot.controller;


import com.bwf.springboot.entity.JsonResult;
import com.bwf.springboot.model.SysUser;
import com.bwf.springboot.service.ISysUserService;
import com.bwf.springboot.utils.JsonResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("mybatis")
public class MyBatisController {

    final static Logger logger = LoggerFactory.getLogger(MyBatisController.class);

    @Autowired
    private ISysUserService userService;

    @RequestMapping("saveUser")
    public JsonResult saveUser() throws Exception {
        logger.info("保存用户，时间：{} , 操作人：{}", new Date(), "admin");

        SysUser user = new SysUser();
        user.setUsername("xiao wang");
        user.setPassword("123");
        user.setAge(32);
        user.setDescription("hello");
        user.setBirthday(new Date());

        userService.saveUser(user);

        return JsonResultUtil.success();
    }


}
