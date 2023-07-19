package com.go2climb.app.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import java.nio.charset.StandardCharsets;
import java.util.*;

public class TokenUtils {
    private final static String ACCESS_TOKEN_SECRET = "4qhq8LrEBfYcaRHxhdb9zURb2rf8e7Ud";//
    private final static Long ACCESS_TOKEN_VALIDITY_SECONDS = 2_292_000L;//

    public static String createToken(String name, String email){//
        long expirationsTime = ACCESS_TOKEN_VALIDITY_SECONDS*1_000;//
        Date expirationDAte = new Date(System.currentTimeMillis()+expirationsTime);//

        Map<String, Object> extra = new HashMap<>();//

        extra.put("name", name);//

        return Jwts.builder()//
                .setSubject(email)//
                .setExpiration(expirationDAte)//
                .addClaims(extra)//
                .signWith(Keys.hmacShaKeyFor(ACCESS_TOKEN_SECRET.getBytes()))//
                .compact();//
    }

    public static UsernamePasswordAuthenticationToken getAuthentication(String token){//
        try {//
            Claims claims = Jwts.parserBuilder()//
                    .setSigningKey(ACCESS_TOKEN_SECRET.getBytes())//
                    .build()//
                    .parseClaimsJws(token)//
                    .getBody();//
            String email = claims.getSubject();//
            return new UsernamePasswordAuthenticationToken(email,null, Collections.emptyList());//
        }catch (JwtException e){//
            return null;//
        }
    }
}
