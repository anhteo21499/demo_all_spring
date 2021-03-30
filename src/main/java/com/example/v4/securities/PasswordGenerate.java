package com.example.v4.securities;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordGenerate {
    public static void main(String[] args) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        String pass = "123456";

        System.out.println(passwordEncoder.encode(pass));
    }
}
