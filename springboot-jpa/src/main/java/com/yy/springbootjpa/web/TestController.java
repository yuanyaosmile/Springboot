package com.yy.springbootjpa.web;

import com.yy.springbootjpa.entity.Student;
import com.yy.springbootjpa.service.AdminUserService;
import com.yy.springbootjpa.service.StudentService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@RestController
public class TestController {

    AdminUserService adminUserService;
    EntityManager entityManager;
    StudentService studentService;

    public TestController(AdminUserService adminUserService, EntityManager entityManager, StudentService studentService) {
        this.adminUserService = adminUserService;
        this.entityManager = entityManager;
        this.studentService = studentService;
    }

    @GetMapping("/hello")
    public String test() {
        return adminUserService.getAdminUserById(1).toString();
    }

    @GetMapping("/raw")
    public String getStudentByRawJpa() {
        Query query = entityManager.createQuery("select s from Student s");
        List<Student> resultList = query.getResultList();
        System.out.println(resultList.size());
        for (int i = 0; i < resultList.size(); i++) {
            Object s = resultList.get(i);
            System.out.println(s.toString());
        }
        Student student = entityManager.find(Student.class, 1L);
        System.out.println(student.toString());
        return "raw";
    }


    @GetMapping("/all")
    public Page<Student> getAllStudent(@PageableDefault(page=3, size = 3) Pageable pageable){
        return studentService.getAllStudent(pageable);
    }
}
