package com.yy.springbootjpa.yy;

import java.lang.reflect.Proxy;

public class Test {
    public static void main(String[] args) {
        Man man = new Man();
        PersonProxy proxy = new PersonProxy(man);
        Person p = (Person) Proxy.newProxyInstance(man.getClass().getClassLoader(), man.getClass().getInterfaces(), proxy);
        p.sayHello();

        Woman woman = new Woman();
        PersonProxy womanProxy = new PersonProxy(woman);
        Person w =(Person) Proxy.newProxyInstance(woman.getClass().getClassLoader(), woman.getClass().getInterfaces(), womanProxy);
        w.sayHello();
    }
}
