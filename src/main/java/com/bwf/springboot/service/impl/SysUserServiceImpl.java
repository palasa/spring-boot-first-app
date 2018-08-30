package com.bwf.springboot.service.impl;

import com.bwf.springboot.mapper.SysUserMapper;
import com.bwf.springboot.model.SysUser;
import com.bwf.springboot.service.ISysUserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class SysUserServiceImpl implements ISysUserService {

    @Autowired
    private SysUserMapper sysUserMapper;

    @Override
    public void saveUser(SysUser sysUser) throws Exception {
        sysUserMapper.insert(sysUser);
    }

    @Override
    public void updateUser(SysUser sysUser) {
        sysUserMapper.updateByPrimaryKeySelective(sysUser);
    }


    @Override
    public void deleteUser(Integer userId) {
        sysUserMapper.deleteByPrimaryKey(userId);
    }

    @Override
    public SysUser queryUserById(Integer userId) {
        return sysUserMapper.selectByPrimaryKey(userId);
    }

    @Override
    public List<SysUser> queryUserList() {
        return null;
    }
}
