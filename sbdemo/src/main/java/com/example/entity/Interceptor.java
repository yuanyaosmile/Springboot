package com.example.entity;



import com.example.invoke.Invocation;

import java.lang.reflect.InvocationTargetException;

/**
 * @Author Barry
 * @date 2019/1/8
 */
public interface Interceptor {

    /**
     * 事前方法
     */
    boolean before();

    /**
     * 后续方法
     */
    void after();

    Object around(Invocation invocation) throws InvocationTargetException,IllegalAccessException;

    //是否返回方法，事件没有异常执行
    void afterReturning();

    void afterThrowing();

    boolean useAround();
}
