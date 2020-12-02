package com.yy.springbootjpa.dao;

import com.yy.springbootjpa.entity.Student;

import java.util.List;
import org.springframework.data.domain.Pageable;

public interface StudentDao {

    List<Student> getAll(Pageable pageable);

    List<Student> getAllStudent();

    Student getStudentById(Long id);

    Student getStudentByName(String name);

    int updateStudent(Student student);
}
