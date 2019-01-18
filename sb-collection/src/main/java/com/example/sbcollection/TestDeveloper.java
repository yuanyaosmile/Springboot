package com.example.sbcollection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @Author Barry
 * @date 2019/1/11
 */
public class TestDeveloper {

    public static void main(String[] args) {
        Developer pythoner = new Developer("Amy", "python", 28);
        Developer javaer = new Developer("Tom", "java", 25);
        Developer goer = new Developer("Carl", "go", 26);

        List<Developer> developerList = new ArrayList<>(10);
        developerList.add(pythoner);
        developerList.add(javaer);
        developerList.add(goer);

        System.out.println("before sorting");
        developerList.stream().map(Developer::getName)
                .forEach(System.out::println);

        System.out.println("------------sorting by Name--------");
        Collections.sort(developerList,Comparator.comparing(Developer::getName));
        for (Developer developer : developerList) {
            System.out.println(developer.getName());
        }

        System.out.println("------------sorting by age--------");
        //Collections.sort(developerList, (d1, d2) -> d1.getAge() - d2.getAge());
        Collections.sort(developerList,Comparator.comparingInt(Developer::getAge));
        developerList.stream().map(Developer::getName).forEach(System.out::println);
    }
}
