package com.yy.springbootjpa.dao.impl;

import com.yy.springbootjpa.dao.StudentDao;
import com.yy.springbootjpa.entity.Student;

import javax.persistence.EntityManager;
import org.springframework.data.domain.Pageable;
import java.util.List;

public class StudentDaoImpl implements StudentDao {

    private EntityManager entityManager;

    public StudentDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Student> getAll(Pageable pageable) {

        return null;
    }

    @Override
    public List<Student> getAllStudent() {
        List<Student> resultList = entityManager.createQuery("select s from Student s").getResultList();
        resultList.forEach(System.out::println);
        return resultList;
    }

    @Override
    public Student getStudentById(Long id) {
        return entityManager.find(Student.class, id);
    }

    @Override
    public Student getStudentByName(String name) {
        //Criteria criteria = new CriteriaQueryImpl(new CriteriaBuilderImpl(),Student.class);
        //return entityManager.createQuery();
        return null;
    }

    @Override
    public int updateStudent(Student student) {
        return 0;
    }
}
