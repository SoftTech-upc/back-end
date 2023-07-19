package com.go2climb.app.security;

import lombok.Data;


//public class AuthResponse {
//    private String token;
//    private UserDetailsImpl userDetails;
//}

@Data
public class AuthResponse {
    private String token;
    private UserDetailsImpl userDetails;

    public AuthResponse(String token, UserDetailsImpl userDetails) {
        this.token = token;
        this.userDetails = userDetails;
    }

    // Getters y setters
}
