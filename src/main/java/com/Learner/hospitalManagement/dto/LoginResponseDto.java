package com.Learner.hospitalManagement.dto;

import lombok.*;
import org.springframework.web.bind.annotation.RequestMapping;


public class LoginResponseDto {

    public String jwt;
    Long userId;

    public LoginResponseDto(String jwt, Long userId) {
        this.jwt = jwt;
        this.userId = userId;
    }

    public LoginResponseDto() {
    }

    public String getJwt() {
        return jwt;
    }

    public void setJwt(String jwt) {
        this.jwt = jwt;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "LoginResponseDto{" +
                "jwt='" + jwt + '\'' +
                ", userId=" + userId +
                '}';
    }
}
