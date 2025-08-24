package com.Learner.hospitalManagement.dto;


import lombok.*;


public class LoginRequestDto {

    public String username;
    public String password;

    public LoginRequestDto(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public LoginRequestDto() {
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

    @Override
    public String toString() {
        return "LoginRequestDto{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
