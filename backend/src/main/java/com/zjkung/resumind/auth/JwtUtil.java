package com.zjkung.resumind.auth;

import java.util.Date;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtUtil {
  private final String SECRET = "your_secret_key";

  public String generateToken(String email) {
    return Jwts.builder()
        .setSubject(email)
        .setIssuedAt(new Date())
        .setExpiration(new Date(System.currentTimeMillis() + 86400000)) // 1 day
        .signWith(SignatureAlgorithm.HS512, SECRET)
        .compact();
  }

  public String validateTokenAndRetrieveSubject(String token) {
    return Jwts.parser()
        .setSigningKey(SECRET)
        .parseClaimsJws(token)
        .getBody()
        .getSubject();
  }
}
