package com.example.sbcollection;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

/**
 * @Author Barry
 * @date 2019/1/11
 */
public class sbLinkedList {
    public static void main(String[] args){
        List<String> staff = new LinkedList<>();
        staff.add("tom");
        staff.add("amy");
        staff.add("lucy");


        ListIterator<String> iterator = staff.listIterator();
        String first = iterator.next().toString();
        String second = iterator.next().toString();
        //iterator.remove();
        iterator.set("carl");
    }
}
