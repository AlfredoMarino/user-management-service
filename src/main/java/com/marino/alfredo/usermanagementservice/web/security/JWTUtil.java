package com.marino.alfredo.usermanagementservice.web.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Date;

public class JWTUtil {

    //TEMP
    private static final String SECRET = "3e9869c65f2b96bee010602d2a1e6460b8f7bb58dbf2bbafc0da6f344701512e";

    private JWTUtil() {
    }

    public static String generateToken(UserDetails userDetails) {
        return Jwts.builder()
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10))
                .signWith(SignatureAlgorithm.HS256, SECRET)
                .compact();
    }

    public static boolean validateToken(String token, UserDetails userDetails) {
        return userDetails.getUsername().equals(extractUsername(token)) && !isTokenExpired(token);
    }

    public static String extractUsername(String token) {
        return getClaims(token).getSubject();
    }

    public static boolean isTokenExpired(String token) {
        return getClaims(token).getExpiration().before(new Date());
    }

    private static Claims getClaims(String token) {
        return Jwts.parser().setSigningKey(SECRET).parseClaimsJws(token).getBody();
    }
}
