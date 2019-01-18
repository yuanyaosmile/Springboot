package com.example.myabstract;

/**
 * @Author Barry
 * @date 2019/1/14
 */
public class Student extends Person implements HomeWork{
    @Override
    public void dream() {
        System.out.println("my dream is getting into a good university");
    }

    @Override
    public void doHomework(String string) {
        System.out.println("my homework is  " + string);
    }
}
