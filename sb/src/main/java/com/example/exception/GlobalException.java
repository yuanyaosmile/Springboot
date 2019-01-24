package com.example.exception;

import com.example.result.CodeMsg;
import lombok.Getter;

@Getter
public class GlobalException extends RuntimeException{
    private static final long serialVersionUID = -8964947306262888533L;
    private CodeMsg codeMsg;

    public GlobalException (CodeMsg codeMsg){
        super();
        this.codeMsg = codeMsg;
    }

}
