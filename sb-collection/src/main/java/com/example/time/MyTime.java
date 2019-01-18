package com.example.time;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * @Author Barry
 * @date 2019/1/16
 */
public class MyTime {

    public static void main(String[] args){
        LocalTime localTime = LocalTime.now();
        System.out.println(localTime);

        LocalDate localDate = LocalDate.now();
        System.out.println(localDate);

        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);

        Instant instant = Instant.now();
        System.out.println(instant);
    }
}
