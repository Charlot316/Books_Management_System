package com.example.demo.Service.Impl;

import com.example.demo.Dao.StudentDao;
import com.example.demo.Entity.Student;
import com.example.demo.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentDao studentDao;
    @Override
    public Student selectStudentByUsername(String username) {
        return studentDao.selectStudentByUsername(username);
    }

    @Override
    public void registerNewStudent(Student student) {
        studentDao.registerNewStudent(student);
    }
}
