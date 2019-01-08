package com.example.validator.impl;

import com.example.entity.User;
import com.example.validator.UserValidator;

/**
 * @Author Barry
 * @date 2019/1/8
 */
public class UserValidatorImpl implements UserValidator {
    @Override
    public boolean validate(User user) {
        System.out.println("引入新的接口："+ UserValidator.class.getSimpleName());
        return user != null;
    }
}
