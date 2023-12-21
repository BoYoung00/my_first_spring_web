package com.in28.minutes.springboot.myfirstspringweb.login;

import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
    public boolean authenticate(String username, String password) {
        boolean isValidUserName = username.equalsIgnoreCase("kim");
        boolean isValidUserPw = password.equalsIgnoreCase("11");

        return isValidUserName && isValidUserPw;
    }
}
