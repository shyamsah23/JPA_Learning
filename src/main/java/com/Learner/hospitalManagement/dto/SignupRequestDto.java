package com.Learner.hospitalManagement.dto;

public class SignupRequestDto {
    public String username;
    public String password;

    public SignupRequestDto(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public SignupRequestDto() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
