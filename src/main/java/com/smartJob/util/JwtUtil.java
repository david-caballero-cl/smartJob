package com.smartJob.util;

import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import io.jsonwebtoken.Jwts;

import java.util.Date;
import java.util.HashMap;

@Component
public class JwtUtil {

    @Value("${jwt.expiration}")
    private Long expiration;

    public String generateToken(String subject){
        return Jwts.builder()
                .setClaims(new HashMap<>())
                .setSubject(subject)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis()+expiration*1000))
                .signWith(Keys.secretKeyFor(SignatureAlgorithm.HS512))
                .compact();
    }

}
