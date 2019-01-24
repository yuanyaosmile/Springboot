package com.example.exception;

import com.example.result.CodeMsg;
import com.example.result.Result;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@ControllerAdvice
@ResponseBody
public class GlobalExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    public Result<String> exceptionHandler(HttpServletRequest request, Exception exception){
        exception.printStackTrace();

        if (exception instanceof GlobalException) {
            GlobalException globalException = (GlobalException) exception;
            return Result.error(globalException.getCodeMsg());
        }else if (exception instanceof BindException) {
            BindException bindException = (BindException)exception;
            List<ObjectError> errors = bindException.getAllErrors();
            ObjectError objectError = errors.get(0);
            return Result.error(CodeMsg.Bind_ERROR.fillArgs(objectError));
        }else {
            return Result.error(CodeMsg.SERVER_ERROR);
        }
    }
}
