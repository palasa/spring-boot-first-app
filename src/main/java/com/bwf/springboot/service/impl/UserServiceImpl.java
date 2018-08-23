package com.bwf.springboot.service.impl;

import com.bwf.springboot.entity.User;
import com.bwf.springboot.repository.UserRepository;
import com.bwf.springboot.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements IUserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User getUser(Integer id) {
        return userRepository.getOne(id);
    }

    @Override
    public User userAdd(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> userList() {
        return userRepository.findAll();
    }

    @Override
    public void userDelete(Integer id) {
        userRepository.deleteById(id);
    }

    @Override
    public User userEdit(User user) {
        return userRepository.save(user);
    }
}
