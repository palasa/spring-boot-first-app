package com.bwf.springboot.service;

import com.bwf.springboot.model.SysUser;

import java.util.List;


public interface ISysUserService {

    void saveUser(SysUser sysUser) throws Exception;

    void updateUser(SysUser sysUser);

    void deleteUser(Integer userId);

    SysUser queryUserById(Integer userId);

    List<SysUser> queryUserList();


}
