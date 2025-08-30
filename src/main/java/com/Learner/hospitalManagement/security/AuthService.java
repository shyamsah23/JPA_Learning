package com.Learner.hospitalManagement.security;

import com.Learner.hospitalManagement.dto.LoginRequestDto;
import com.Learner.hospitalManagement.dto.LoginResponseDto;
import com.Learner.hospitalManagement.dto.SignupRequestDto;
import com.Learner.hospitalManagement.dto.SignupResponseDto;
import com.Learner.hospitalManagement.entity.User;
import com.Learner.hospitalManagement.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authorization.AuthorizationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private AuthUtil authUtil;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public LoginResponseDto login(LoginRequestDto loginRequestDto) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequestDto.getUsername(),loginRequestDto.getPassword())
        );

        if(authentication == null) {
            System.out.println("AuthManager Fail");
        }

        User user = (User) authentication.getPrincipal();
        String token = authUtil.generateJwtsecretKey(user);
        return new LoginResponseDto(token, user.getId());

    }

    public SignupResponseDto signup(SignupRequestDto signupRequestDto) {
        User user = userRepository.findByUsername(signupRequestDto.getUsername()).orElse(null);

        if (user != null) {
            System.out.println("User Already Prsent");
        }

        user = userRepository.save(new User(signupRequestDto.getUsername(),passwordEncoder.encode(signupRequestDto.getPassword())));
        return new SignupResponseDto(user.getId(),user.getUsername());
    }
}
