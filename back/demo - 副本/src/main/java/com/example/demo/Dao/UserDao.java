package com.example.demo.Dao;

import com.example.demo.Entity.Student;
import com.example.demo.Entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserDao {
    public User selectUserByUsername(String username);
    public void registerNewUser(User user);
}
