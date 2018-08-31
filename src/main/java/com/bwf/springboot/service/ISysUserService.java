package com.bwf.springboot.service;

import com.bwf.springboot.model.SysUser;

import java.util.List;


public interface ISysUserService {

    SysUser addUser(SysUser sysUser) throws Exception;

    SysUser updateUser(SysUser sysUser);

    SysUser deleteUser(Integer userId);

    SysUser queryUserById(Integer userId);

    List<SysUser> queryUserList();


}
