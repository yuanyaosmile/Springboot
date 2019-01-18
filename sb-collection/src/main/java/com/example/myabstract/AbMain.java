package com.example.myabstract;

/**
 * @Author Barry
 * @date 2019/1/14
 */
public class AbMain {

    public static void main(String[] args) {
        Student stu = new Student();
        stu.setUsername("chali");
        stu.dream();
        stu.hello(stu.getUsername());
        stu.doHomework("math");

        Teacher teacher = new Teacher();
        teacher.setUsername("lisa");
        teacher.dream();
        teacher.hello(teacher.getUsername());

    }




}
