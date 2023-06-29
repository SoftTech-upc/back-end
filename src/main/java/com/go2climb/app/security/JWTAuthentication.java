package com.go2climb.app.security;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


import java.io.IOException;
import java.util.Collections;

public class JWTAuthentication  extends UsernamePasswordAuthenticationFilter {
//    public Authentication attemptAuthentication(HttpServletRequest request,
//                                                HttpServletResponse response) throws AuthenticationException{
//        AuthCredentials authCredentials = new AuthCredentials();
//
//        try {
//            authCredentials = new ObjectMapper().readValue(request.getReader(), AuthCredentials.class);
//        }catch (IOException e){
//
//        }
//
//        UsernamePasswordAuthenticationToken usernamePAT = new UsernamePasswordAuthenticationToken(
//                authCredentials.getEmail(),
//                authCredentials.getPassword(),
//                Collections.emptyList()
//        );
//        return getAuthenticationManager().authenticate(usernamePAT);
//    }
public Authentication attemptAuthentication(HttpServletRequest request,
                                               HttpServletResponse response) throws AuthenticationException {
    AuthCredentials authCredentials = new AuthCredentials();

    try {
        authCredentials = new ObjectMapper().readValue(request.getReader(), AuthCredentials.class);
    } catch (IOException e) {
        // Manejar la excepción adecuadamente
    }

    UsernamePasswordAuthenticationToken usernamePAT = new UsernamePasswordAuthenticationToken(
            authCredentials.getEmail(),
            authCredentials.getPassword(),
            Collections.emptyList()
    );
    return getAuthenticationManager().authenticate(usernamePAT);
}


//    protected void successfulAuthentication(HttpServletRequest request,
//                                            HttpServletResponse response,
//                                            FilterChain chain,
//                                            Authentication authResult) throws IOException, ServletException{
//        UserDetailsImpl userDetailsImpl = (UserDetailsImpl) authResult.getPrincipal();
//        String token = TokenUtils.createToken(userDetailsImpl.getName(), userDetailsImpl.getUsername());
//
//        response.addHeader("Authorization","Bearer"+token);
//        response.getWriter().flush();
//
//
//        super.successfulAuthentication(request,response,chain,authResult);
//    }

//    protected void successfulAuthentication(HttpServletRequest request,
//                                            HttpServletResponse response,
//                                            FilterChain chain,
//                                            Authentication authResult) throws IOException, ServletException {
//        UserDetailsImpl userDetailsImpl = (UserDetailsImpl) authResult.getPrincipal();
//        String token = TokenUtils.createToken(userDetailsImpl.getName(), userDetailsImpl.getUsername());
//
//        // Agrega el objeto UserDetailsImpl al cuerpo de la respuesta
//        ObjectMapper objectMapper = new ObjectMapper();
//        String userDetailsJson = objectMapper.writeValueAsString(userDetailsImpl);
//        response.setContentType("application/json");
//        response.getWriter().write(userDetailsJson);
//
//        response.addHeader("Authorization", "Bearer " + token);
//        response.getWriter().flush();
//
//        super.successfulAuthentication(request, response, chain, authResult);
//    }

//    protected void successfulAuthentication(HttpServletRequest request,
//                                            HttpServletResponse response,
//                                            FilterChain chain,
//                                            Authentication authResult) throws IOException, ServletException {
//        UserDetailsImpl userDetailsImpl = (UserDetailsImpl) authResult.getPrincipal();
//        String token = TokenUtils.createToken(userDetailsImpl.getName(), userDetailsImpl.getUsername());
//
//        ObjectMapper objectMapper = new ObjectMapper();
//        String tokenJson = objectMapper.writeValueAsString(Collections.singletonMap("token", token));
//
//        response.setContentType("application/json");
//        response.getWriter().write(tokenJson);
//    }

    protected void successfulAuthentication(HttpServletRequest request,
                                            HttpServletResponse response,
                                            FilterChain chain,
                                            Authentication authResult) throws IOException, ServletException {
        UserDetailsImpl userDetailsImpl = (UserDetailsImpl) authResult.getPrincipal();
        String token = TokenUtils.createToken(userDetailsImpl.getName(), userDetailsImpl.getUsername());

        AuthResponse authResponse = new AuthResponse(token, userDetailsImpl);

        ObjectMapper objectMapper = new ObjectMapper();
        String responseJson = objectMapper.writeValueAsString(authResponse);

        response.setContentType("application/json");
        response.getWriter().write(responseJson);
    }



}
