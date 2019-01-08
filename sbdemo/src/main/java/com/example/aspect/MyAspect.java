package com.example.aspect;

import com.example.entity.User;
import com.example.validator.UserValidator;
import com.example.validator.impl.UserValidatorImpl;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

/**
 * @Author Barry
 * @date 2019/1/8
 */
@Aspect
public class MyAspect {
   /* @DeclareParents(value= "com.example.service.impl.UserServiceImpl+", defaultImpl= UserValidatorImpl.class)
    public UserValidator userValidator;
*/
    @Pointcut(value = " execution(* com.example.service.impl.UserServiceImpl.printUser(..))")
    public void pointCut() {
    }

   /* @Before("execution(*com.example.service.impl.UserServiceImpl.printUser(..))")
    public void beforeParam( User user) {
        System.out.println("before ......");
    }*/

    @Before("pointCut()")
    public void before() {
        System.out.println("before ......");
    }

    @After("pointCut()")
    public void after() {
        System.out.println("after ......");
    }


    @AfterReturning("pointCut())")
    public void afterReturning() {
        System.out.println("afterReturning ......");
    }

    @AfterThrowing("pointCut()")
    public void afterThrowing() {
        System.out.println("afterThrowing ......");
    }


    @Around("pointCut()")
    public void around(ProceedingJoinPoint jp) throws Throwable {
        System.out.println("around before......");
        jp.proceed();
        System.out.println("around after......");
    }

}
