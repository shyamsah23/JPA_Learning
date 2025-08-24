package com.Learner.hospitalManagement.dto;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class LoginRequestDto {

    public String username;
    public String password;
}
