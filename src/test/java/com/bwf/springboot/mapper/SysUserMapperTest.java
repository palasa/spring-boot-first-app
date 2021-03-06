package com.bwf.springboot.mapper;

import com.bwf.springboot.model.SysUser;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SysUserMapperTest {

    @Autowired
    SysUserMapper userMapper;

    final static Logger logger = LoggerFactory.getLogger(SysUserMapperTest.class);

//    private Sid sid = new Sid();

    @Before
    public void before() {
        logger.info("操作用户，时间：{} , 操作人：{}", new Date(), "admin");
    }

    @Test
    public void addUser() {

        SysUser user = new SysUser();
//        user.setId(sid.nextShort());
        user.setUsername("xiao wang");
        user.setPassword("123");
        user.setAge(32);
        user.setDescription("hello");
        user.setBirthday(new Date());
        Assert.assertEquals(1,userMapper.insert(user));

    }

    @Test
    public void updateUser() {

//        SysUser user = userMapper.selectAll().get(0);
//        System.out.println( "用户信息：" + user);
        SysUser user = new SysUser();
        user.setId(1);
        user.setAge(18);
        user.setBirthday(new Date());
        user.setDescription("updated");
        user.setUsername("updated");
        user.setPassword("updated");

        Assert.assertEquals(1,userMapper.updateByPrimaryKeySelective(user));

    }


    @Test
    public void deleteUser() {

        SysUser user = new SysUser();
        List<SysUser> userList = userMapper.selectAll();
        user.setId(userList.get(userList.size() - 1).getId());
        Assert.assertEquals( 1, userMapper.deleteByPrimaryKey(user.getId()));

    }
}