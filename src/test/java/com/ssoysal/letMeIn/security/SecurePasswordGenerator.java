package com.ssoysal.letMeIn.security;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class SecurePasswordGenerator {
 
    public static void main(String[] args) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        
        String[] passwords = {"c!//q)Nr$CFC", "NV@2VmTjr&Jx"};
        
        for(int i = 0; i < 2; i++) System.out.println(encoder.encode(passwords[i]));
    }
 
}
