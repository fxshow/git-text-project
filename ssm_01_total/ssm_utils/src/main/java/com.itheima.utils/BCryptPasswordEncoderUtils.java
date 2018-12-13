package com.itheima.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class BCryptPasswordEncoderUtils {
    private static BCryptPasswordEncoder bCryptPasswordEncoder=new BCryptPasswordEncoder();

    public static String passwordEncoder(String password){
        return bCryptPasswordEncoder.encode(password);
    }

    public static void main(String[] args) {
        String password="root";
        String encoder = passwordEncoder(password);//手动的密码
        //$2a$10$snWLaHQOijqKR0ddlqN86.r044XVzDtFz/JSu.aoHMYpeU/CM9UoW
        System.out.println(encoder);
    }
}
