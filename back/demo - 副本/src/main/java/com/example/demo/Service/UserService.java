package com.example.demo.Service;

import com.example.demo.Entity.Student;
import com.example.demo.Entity.User;

public interface UserService {
    public User selectUserByUsername(String username);
    public void registerNewUser(User user);
}
