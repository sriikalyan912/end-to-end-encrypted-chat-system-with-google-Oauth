package com.quickchat.chat_server.Services;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;

@Service
public class JwtService {

    @Value("${jwt.secret-key}")
    private String secretKey; // 512-bit secret key

    private SecretKey key;


    public String generateToken(UserDetails userDetails) {
        if(this.key == null) {
            this.key = Keys.hmacShaKeyFor(
                    this.secretKey.getBytes(StandardCharsets.UTF_8)
            );
        }
        return Jwts.builder()
                .subject(userDetails.getUsername())
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60))
                .signWith(this.key) // The algorithm (HS256 / HS384 / HS512) is inferred from key size.
                .compact();
    }

    public boolean validateToken(String token) {
        if(this.key == null) {
            this.key = Keys.hmacShaKeyFor(
                    this.secretKey.getBytes(StandardCharsets.UTF_8)
            );
        }
        try {
            Jwts.parser()
                    .verifyWith(this.key)
                    .build()
                    .parseSignedClaims(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public String getUserName(String token) {
        if(this.key == null) {
            this.key = Keys.hmacShaKeyFor(
                    this.secretKey.getBytes(StandardCharsets.UTF_8)
            );
        }
        try {
            Claims claims = Jwts.parser()
                    .verifyWith(this.key)
                    .build()
                    .parseSignedClaims(token)
                    .getPayload();
            return claims.getSubject();
        } catch (Exception e) {
            return "";
        }
    }
}
