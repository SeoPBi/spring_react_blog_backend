package com.example.spring_react_blog.controller;

import com.example.spring_react_blog.dto.ResponseDto;
import com.example.spring_react_blog.dto.SignInDto;
import com.example.spring_react_blog.dto.SignInResponseDto;
import com.example.spring_react_blog.dto.SignUpDto;
import com.example.spring_react_blog.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    AuthService authService;

    @PostMapping("/signUp")
    public ResponseDto<?> signUp(@RequestBody SignUpDto requestBody) {
        ResponseDto<?> result = authService.signUp(requestBody);
        return result;
    }

    @PostMapping("/signIn")
    public ResponseDto<SignInResponseDto> signIn(@RequestBody SignInDto requestBody) {
        ResponseDto<SignInResponseDto> result = authService.signIn(requestBody);
        return result;
    }
}
