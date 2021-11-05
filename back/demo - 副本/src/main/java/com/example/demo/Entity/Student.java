package com.example.demo.Entity;

import javax.persistence.*;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer s_id;

    private String username;
    private String password;

    public Student(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public Student() {

    }


    public void setId(Integer s_id) {
        this.s_id = s_id;
    }

    public Integer getId() {
        return s_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
