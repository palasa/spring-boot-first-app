package com.bwf.springboot.service;

import com.bwf.springboot.model.SysUser;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ISysUserService {

    void saveUser(SysUser sysUser) throws Exception;

    void updateUser(SysUser sysUser);

    void deleteUser(Integer userId);

    SysUser queryUserById(Integer userId);

    List<SysUser> queryUserList();


}
