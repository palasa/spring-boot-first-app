package com.bwf.springboot.service.impl;

import com.bwf.springboot.mapper.SysUserMapper;
import com.bwf.springboot.model.SysUser;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SysUserServiceImplTest {

    @Autowired
    SysUserServiceImpl userService;

    @Autowired
    SysUserMapper userMapper;

    @Test
    public void updateUser() {

        SysUser user = new SysUser();
        user.setId(5);
        user.setUsername("updated");
        user.setPassword("updated");
        user.setAge(32);
        user.setDescription("updated");
        user.setBirthday(new Date());

        Assert.assertEquals( "updated" , userService.updateUser(user).getDescription() );

    }

    @Test
    public void addUser()  {
        SysUser user = new SysUser();
        user.setUsername("new");
        user.setPassword("new");
        user.setAge(15);
        user.setDescription("new");
        user.setBirthday(new Date());
        Assert.assertEquals( "new" , userService.addUser( user ).getUsername() );
    }

    @Test
    public void deleteUser() {

        SysUser firstUser = userMapper.selectAll().get(0);
        Assert.assertEquals( firstUser.getId() ,  userService.deleteUser( firstUser.getId() ).getId() );
    }

    @Test
    public void queryUserById() {
        SysUser user = userService.queryUserById(6);
        Assert.assertEquals( "hello" , user.getDescription() );
    }

    @Test
    public void queryUserList() {
        List<SysUser> users = userService.queryUserList();
        Assert.assertEquals( 4, users.size() );
    }

    @Test
    public void queryUserListPaged() {
        List<SysUser> userList = userService.queryUserListPaged(new SysUser(), 1, 5);
        Assert.assertEquals(5, userList.size());

        for (SysUser user : userList) {
            System.err.println(user);
        }
    }
}