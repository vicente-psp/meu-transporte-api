package com.fatesg.meutransporteapi.security;

import com.fatesg.meutransporteapi.constant.SecurityConstants;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.util.Calendar;
import java.util.List;

@Component
public class JwtManager {

    public String createToken(String userName, List<String> roles) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH, SecurityConstants.JWT_EXP_DAYS);
        String jwt = Jwts.builder()
                .setSubject(userName)
                .setExpiration(calendar.getTime())
                .claim(SecurityConstants.JWT_ROLE_KEY, roles)
                .signWith(SignatureAlgorithm.HS512, SecurityConstants.API_KEY.getBytes())
                .compact();
        return jwt;
    }

    public Claims parseToken(String token) throws JwtException {
        Claims claims = Jwts.parser()
                                .setSigningKey(SecurityConstants.API_KEY.getBytes())
                                .parseClaimsJws(token)
                                .getBody();

        return claims;
    }

}
