package com.example.spring_react_blog.dto;

import com.example.spring_react_blog.entity.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SignInResponseDto {

    private String token;

    // 토큰 만료시간
    private int exprTime;

    private UserEntity user;
}
