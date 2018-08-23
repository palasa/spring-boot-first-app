package com.bwf.springboot.service;

import com.bwf.springboot.entity.User;

import java.util.List;

public interface IUserService {

    User getUser(Integer id);

    User userAdd(User user);

    List<User> userList();

    void userDelete(Integer id);

    User userEdit(User user);
}
