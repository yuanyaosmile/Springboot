package com.yy.springbootjpa.service.impl;

import com.yy.springbootjpa.dao.StudentRepository;
import com.yy.springbootjpa.dao.impl.StudentDaoImpl;
import com.yy.springbootjpa.entity.Student;
import com.yy.springbootjpa.service.StudentService;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {

    private StudentRepository studentDao;

    public StudentServiceImpl(StudentRepository studentDao) {
        this.studentDao = studentDao;
    }

    @Override
    public Page<Student> getAllStudent(Pageable pageable) {
        return studentDao.findAll(pageable);
    }
}
