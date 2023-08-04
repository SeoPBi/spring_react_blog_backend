package com.example.spring_react_blog.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SignInDto {

    // @NotBrank : 반드시 값이 존재하고 공백 문자를 제외한 길이가 0보다 커야 한다.
    @NotBlank
    private String userEmail;

    @NotBlank
    private String userPassword;
}
