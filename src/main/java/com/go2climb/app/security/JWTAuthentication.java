package com.go2climb.app.security;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.io.IOException;
import java.util.Collections;

public class JWTAuthentication  extends UsernamePasswordAuthenticationFilter {
    public Authentication attemptAuthentication(HttpServletRequest request,
                                                HttpServletResponse response) throws AuthenticationException{
        AuthCredentials authCredentials = new AuthCredentials();

        try {
            authCredentials = new ObjectMapper().readValue(request.getReader(), AuthCredentials.class);
        }catch (IOException e){

        }

        UsernamePasswordAuthenticationToken usernamePAT = new UsernamePasswordAuthenticationToken(
                authCredentials.getEmail(),
                authCredentials.getPassword(),
                Collections.emptyList()
        );
        return getAuthenticationManager().authenticate(usernamePAT);
    }

    protected void successfulAuthentication(HttpServletRequest request,
                                            HttpServletResponse response,
                                            FilterChain chain,
                                            Authentication authResult) throws IOException, ServletException{
        UserDetailsImpl userDetailsImpl = (UserDetailsImpl) authResult.getPrincipal();
        String token = TokenUtils.createToken(userDetailsImpl.getName(), userDetailsImpl.getUsername());

        response.addHeader("Authorization","Bearer"+token);
        response.getWriter().flush();

        super.successfulAuthentication(request,response,chain,authResult);
    }
}
