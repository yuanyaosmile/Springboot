package com.example.result;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Result<T> {

    private int code;
    private String msg;
    private T data;

    private Result(T data){
        this.code = 20000;
        this.msg = "success";
        this.data = data;
    }

    private Result(CodeMsg codeMsg){
        if (codeMsg  == null){
            return;
        }
        this.code = code;
        this.msg = msg;
    }

    /**
     * 成功时候调用该方法
     */
    public static  <T> Result<T> success(T data){
        return new Result<>(data);
    }

    public static <T> Result<T> error(CodeMsg codeMsg){
        return new Result<>(codeMsg);
    }
}
