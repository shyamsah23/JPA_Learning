package com.Learner.hospitalManagement.security;


import com.Learner.hospitalManagement.entity.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;

@Component
public class AuthUtil {

    @Value("${jwt.Secret.Key}")
    private String jwtsecretKey;

    private SecretKey getsecretKey(){
        return Keys.hmacShaKeyFor(jwtsecretKey.getBytes(StandardCharsets.UTF_8));
    }

    public  String generateJwtsecretKey(User user){
       return Jwts.builder()
               .subject(user.getUsername())
               .claim("userId",user.getId().toString())
               .issuedAt(new Date())
               .expiration(new Date(System.currentTimeMillis()+ 10*1000*60))
               .signWith(getsecretKey())
               .compact();
    }

}
