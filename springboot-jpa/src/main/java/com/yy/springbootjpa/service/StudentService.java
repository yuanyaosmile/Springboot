package com.yy.springbootjpa.service;

import com.yy.springbootjpa.entity.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface StudentService {
    Page<Student> getAllStudent(Pageable pageable);
}
