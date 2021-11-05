package com.example.demo.Service;

import com.example.demo.Entity.Student;

public interface StudentService {
    public Student selectStudentByUsername(String username);
    public void registerNewStudent(Student student);
}
