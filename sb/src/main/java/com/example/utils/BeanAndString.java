package com.example.utils;

import com.alibaba.fastjson.JSON;

public class BeanAndString {


    public static  <T> String beanToString(T value) {
        if (value == null) {
            return null;
        }

        Class<?> clazz = value.getClass();
        if (clazz == int.class || clazz == Integer.class) {
            return " " + value;
        } else if (clazz == String.class) {
            return (String) value;
        } else if (clazz == long.class || clazz == Long.class) {
            return "" + value;
        } else {
            return JSON.toJSONString(value);
        }
    }

    public static  <T> T stringToBean(String string, Class<T> clazz) {
        if (string == null || string.length() <= 0 || clazz == null) {
            return null;
        }
        if (clazz == int.class || clazz == Integer.class) {
            return (T)Integer.valueOf(string);
        }else if (clazz == String.class) {
            return (T)String.valueOf(string);
        }else if(clazz == long.class || clazz == Long.class){
            return (T)Long.valueOf(string);
        }else {
            return JSON.toJavaObject(JSON.parseObject(string),clazz);
        }

    }
}
