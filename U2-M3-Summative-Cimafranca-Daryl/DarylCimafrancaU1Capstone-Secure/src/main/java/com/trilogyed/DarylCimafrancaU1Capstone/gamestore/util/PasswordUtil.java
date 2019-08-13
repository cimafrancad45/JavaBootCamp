package com.trilogyed.DarylCimafrancaU1Capstone.gamestore.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class PasswordUtil {
    public static void main(String[] args) {
        PasswordEncoder enc = new BCryptPasswordEncoder();

        String password = "password";

        String encodedPassword = enc.encode(password);

        System.out.println(encodedPassword);
    }
}
