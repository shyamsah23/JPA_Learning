package com.Learner.hospitalManagement.controller;


import com.Learner.hospitalManagement.dto.LoginRequestDto;
import com.Learner.hospitalManagement.dto.LoginResponseDto;
import com.Learner.hospitalManagement.entity.User;
import com.Learner.hospitalManagement.security.AuthService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDto> login(@RequestBody LoginRequestDto loginRequestDto) {

        return ResponseEntity.ok(authService.login(loginRequestDto));
    }
}
