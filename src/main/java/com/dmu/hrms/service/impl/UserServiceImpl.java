package com.dmu.hrms.service.impl;

import com.dmu.hrms.entity.User;
import com.dmu.hrms.mapper.UserMapper;
import com.dmu.hrms.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author : hadoo
 * @Date : 2020/12/20 18:49
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    @Override
    public User loadByUsername(String username) {
        return userMapper.findByUsername(username);
    }

    @Override
    public void addUser(User user) {
        userMapper.insert(user);
    }
}