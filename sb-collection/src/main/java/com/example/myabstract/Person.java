package com.example.myabstract;

import lombok.Getter;
import lombok.Setter;

/**
 * @Author Barry
 * @date 2019/1/14
 */
@Setter
@Getter
public abstract class Person {
    private String  username;
    private int age;

    public void hello(String string){
        System.out.println("Hello  " + string);
    }

    public abstract void dream();
}
