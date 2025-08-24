package com.Learner.hospitalManagement.dto;

import lombok.*;
import org.springframework.web.bind.annotation.RequestMapping;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class LoginResponseDto {

    public String jwt;
    Long userId;

}
