package com.Learner.hospitalManagement.controller;


import com.Learner.hospitalManagement.dto.LoginRequestDto;
import com.Learner.hospitalManagement.dto.LoginResponseDto;
import com.Learner.hospitalManagement.dto.SignupRequestDto;
import com.Learner.hospitalManagement.dto.SignupResponseDto;
import com.Learner.hospitalManagement.entity.User;
import com.Learner.hospitalManagement.security.AuthService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private static final Logger logger = LoggerFactory.getLogger(AuthController.class);
    
    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDto> login(@RequestBody LoginRequestDto loginRequestDto) {
        logger.info("Inside Login Controller");
        return ResponseEntity.ok(authService.login(loginRequestDto));
    }

    @PostMapping("signup")
    public ResponseEntity<SignupResponseDto> signup(@RequestBody SignupRequestDto signupRequestDto){
        return ResponseEntity.ok(authService.signup(signupRequestDto));
    }
}
