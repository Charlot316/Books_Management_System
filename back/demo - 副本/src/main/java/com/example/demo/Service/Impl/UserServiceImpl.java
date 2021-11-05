package com.example.demo.Service.Impl;

import com.example.demo.Dao.UserDao;
import com.example.demo.Entity.Student;
import com.example.demo.Entity.User;
import com.example.demo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao userDao;
    @Override
    public User selectUserByUsername(String username) {
        return userDao.selectUserByUsername(username);
    }

    @Override
    public void registerNewUser(User user) {
        userDao.registerNewUser(user);
    }
}
