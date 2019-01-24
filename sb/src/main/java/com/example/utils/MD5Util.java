package com.example.utils;

import org.apache.commons.codec.digest.DigestUtils;

public class MD5Util {
    public static String md5(String string) {
        return DigestUtils.md5Hex(string);
    }

    private static final String salt = "1a2b3c4d";

    public static String inputPassToFromPass(String inputPass) {
        String string = "" + salt.charAt(0) + salt.charAt(2) + inputPass + salt.charAt(5) + salt.charAt(4);
        return md5(string);
    }

    //两次md5加密
    public static String formPassTodbPass(String fromPass, String salt) {
        String string = "" + salt.charAt(0) + salt.charAt(2) + fromPass + salt.charAt(5) + salt.charAt(4);
        return md5(string);
    }

    public static String inputPassToDbPass(String inputPass, String saltDB){
        String formPass  = inputPassToFromPass(inputPass);
        String dbPass = formPassTodbPass(formPass, saltDB);
        return dbPass;
    }

    public static void main(String[] args) {
        System.out.println(inputPassToDbPass("123456",salt));
    }
}
