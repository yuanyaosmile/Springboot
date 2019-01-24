package com.example.pojo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Result {
    private boolean success = false;
    private String msg;

    public Result(){

    }

    public Result(boolean success, String msg){
        this.success = success;
        this.msg = msg;
    }
}
