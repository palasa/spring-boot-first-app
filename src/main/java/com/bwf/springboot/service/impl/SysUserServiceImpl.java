package com.bwf.springboot.service.impl;

import com.bwf.springboot.mapper.SysUserMapper;
import com.bwf.springboot.model.SysUser;
import com.bwf.springboot.service.ISysUserService;
import com.github.pagehelper.PageHelper;
import com.mysql.cj.core.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Transactional
@Service
public class SysUserServiceImpl implements ISysUserService {

    @Autowired
    private SysUserMapper userMapper;

    @Override
    public SysUser addUser(SysUser sysUser)  {
        userMapper.insert(sysUser);
        return userMapper.selectOne( sysUser );
    }

    @Override
    public SysUser updateUser(SysUser sysUser) {
        userMapper.updateByPrimaryKeySelective(sysUser);
        return userMapper.selectOne( sysUser );
    }

    @Override
    public SysUser deleteUser(Integer userId) {
        SysUser user = userMapper.selectByPrimaryKey( userId );
        userMapper.deleteByPrimaryKey(userId);
        return user;
    }

    @Override
    public SysUser queryUserById(Integer userId) {
        return userMapper.selectByPrimaryKey(userId);
    }

    @Override
    public List<SysUser> queryUserList() {
        return userMapper.selectAll();
    }

    @Override
    public List<SysUser> queryUserListPaged(SysUser user, Integer page, int pageSize) {

        PageHelper.startPage(page, pageSize);

        Example example = new Example(SysUser.class);
        Example.Criteria criteria = example.createCriteria();

        if (!StringUtils.isEmptyOrWhitespaceOnly(user.getUsername())) {
            criteria.andLike("username", "%" + user.getUsername() + "%");
        }

        example.orderBy("birthday").desc();

        List<SysUser> userList = userMapper.selectByExample(example);
        return userList;
    }
}
