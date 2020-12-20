package com.dmu.hrms.service;

import com.dmu.hrms.entity.User;

/**
 * @Author : hadoo
 * @Date : 2020/12/20 18:43
 */
public interface UserService {
    User loadByUsername(String username);

    void addUser(User user);
}