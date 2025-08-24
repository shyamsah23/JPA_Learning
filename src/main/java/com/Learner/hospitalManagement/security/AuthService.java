package com.Learner.hospitalManagement.security;

import com.Learner.hospitalManagement.dto.LoginRequestDto;
import com.Learner.hospitalManagement.dto.LoginResponseDto;
import com.Learner.hospitalManagement.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authorization.AuthorizationManager;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private AuthUtil authUtil;

    private AuthenticationManager authenticationManager;

    public LoginResponseDto login(LoginRequestDto loginRequestDto) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequestDto.getUsername(),loginRequestDto.getPassword())
        );

        User user = (User) authentication.getPrincipal();
        String token = authUtil.generateJwtsecretKey(user);
        return new LoginResponseDto(token, user.getId());

    }
}
