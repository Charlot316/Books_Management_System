package com.example.demo.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer userId;
    private String username;
    private String password;
    private Integer role;
    private String email;
    private Integer sex;
    private Integer ulendcount;

    public User(String username, String password, Integer role, String email, Integer sex) {
        this.username = username;
        this.password = password;
        this.role = role;
        this.email = email;
        this.sex = sex;
        this.ulendcount = 0;
    }

    public User() {

    }

    public Integer getUserId() {
        return userId;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public Integer getRole() {
        return role;
    }

    public String getEmail() {
        return email;
    }

    public Integer getSex() {
        return sex;
    }

    public Integer getUlendcount() {
        return ulendcount;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRole(Integer role) {
        this.role = role;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public void setUlendcount(Integer ulendcount) {
        this.ulendcount = ulendcount;
    }
}
