package com.example.result;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CodeMsg {
    private int code;
    private String msg;

    public static CodeMsg SUCCESS = new CodeMsg(20000, "success");

    public static CodeMsg SERVER_ERROR = new CodeMsg(50001, "服务器内部错误！");

    public static CodeMsg MOBILE_EMPTY = new CodeMsg(50002, "手机号不存在");

    public static CodeMsg PASSWORD_EMPTY = new CodeMsg(50003, "请输入密码");

    public static CodeMsg PASSWORD_ERROR = new CodeMsg(50004, "wrong password");

    public static CodeMsg Bind_ERROR = new CodeMsg(50005, "参数校验异常");

    public static CodeMsg MIAOSHA_FAIL = new CodeMsg(60001, "商品已经售罄");

    public static CodeMsg MIAOSHA_REPATE = new CodeMsg(60002, "不能重复秒杀");

    public CodeMsg fillArgs(Object... object) {
        int code = this.code;
        String msg = String.format(this.msg, object);
        return new CodeMsg(code, msg);
    }
}
