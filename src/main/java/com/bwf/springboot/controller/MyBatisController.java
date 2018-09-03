package com.bwf.springboot.controller;


import com.bwf.springboot.entity.JsonResult;
import com.bwf.springboot.model.SysUser;
import com.bwf.springboot.service.ISysUserService;
import com.bwf.springboot.utils.JsonResultUtil;
import org.n3r.idworker.Sid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("mybatis")
public class MyBatisController {

    final static Logger logger = LoggerFactory.getLogger(MyBatisController.class);

    @Autowired
    private ISysUserService userService;

    //    @Autowired
    private Sid sid = new Sid();

    @RequestMapping("addUser")
    public JsonResult addUser() throws Exception {
        logger.info("新增用户，时间：{} , 操作人：{}", new Date(), "admin");

        SysUser user = new SysUser();
        user.setUsername("xiao wang");
        user.setPassword("123");
        user.setAge(32);
        user.setDescription("hello");
        user.setBirthday(new Date());

        userService.addUser(user);

        return JsonResultUtil.success();
    }

    @RequestMapping("updateUser")
    public JsonResult updateUser()  {
        logger.info("保存用户，时间：{} , 操作人：{}", new Date(), "admin");

        SysUser user = new SysUser();
        user.setId(1);
        user.setUsername("updated");
        user.setPassword("updated");
        user.setAge(32);
        user.setDescription("updated");
        user.setBirthday(new Date());

        userService.updateUser(user);

        return JsonResultUtil.success();
    }

    @GetMapping("queryUserListPaged/{page}/{pageSize}")
    public JsonResult queryUserListPaged(
            @PathVariable Integer page,
            @PathVariable Integer pageSize
    ) {
        if (page == null) {
            page = 1;
        }
        if (pageSize == null) {
            pageSize = 10;
        }

        SysUser user = new SysUser();

        List<SysUser> userList = userService.queryUserListPaged(user, page, pageSize);
        return JsonResultUtil.success(userList);
    }


}
