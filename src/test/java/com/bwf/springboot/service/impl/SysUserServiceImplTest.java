package com.bwf.springboot.service.impl;

import com.bwf.springboot.model.SysUser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SysUserServiceImplTest {

    @Autowired
    SysUserServiceImpl userService;

    @Test
    public void updateUser() {

        SysUser user = new SysUser();
        user.setId("180831BXPNRYGBMW");
        user.setUsername("updated");
        user.setPassword("updated");
        user.setAge(32);
        user.setDescription("updated");
        user.setBirthday(new Date());

        userService.updateUser(user);

    }
}