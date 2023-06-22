package com.go2climb.app.security;

import lombok.Data;

@Data
public class AuthCredentials {
    private String email;
    private String password;
}
