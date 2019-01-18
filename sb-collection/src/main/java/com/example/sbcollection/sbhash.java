package com.example.sbcollection;

import java.util.SortedSet;
import java.util.TreeSet;

/**
 * @Author Barry
 * @date 2019/1/11
 */
public class sbhash {
    public static void main(String[] args) {
        SortedSet<String> soter = new TreeSet<>();
        soter.add("Amy");
        soter.add("Carl");
        soter.add("Bob");
        soter.stream().map(name -> name.toUpperCase())
                .forEach(System.out::println);
    }

}
