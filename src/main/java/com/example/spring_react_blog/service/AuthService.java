package com.example.spring_react_blog.service;

import com.example.spring_react_blog.dto.ResponseDto;
import com.example.spring_react_blog.dto.SignInDto;
import com.example.spring_react_blog.dto.SignInResponseDto;
import com.example.spring_react_blog.dto.SignUpDto;
import com.example.spring_react_blog.entity.UserEntity;
import com.example.spring_react_blog.repository.UserRepository;
import com.example.spring_react_blog.security.TokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    TokenProvider tokenProvider;

    public ResponseDto<?> signUp(SignUpDto dto) {
        String userEmail = dto.getUserEmail();
        String userPassword = dto.getUserPassword();
        String userPasswordCheck = dto.getUserPasswordCheck();

        // email 중복 확인
        try {
            if(userRepository.existsById(userEmail))
                return ResponseDto.setFailed("Existed Email");
        } catch (Exception e) {
            return ResponseDto.setFailed("DataBase Error!");
        }

        // 비밀번호가 서로 다르면 failed response 반환!
        if(!userPassword.equals(userPasswordCheck))
            return ResponseDto.setFailed("password dose not matched!");

        // UserEntity 생성
        UserEntity userEntity = new UserEntity(dto);

        // UserRepository를 이용해서 데이터베이스에 Entity 저장!!
        try {
            userRepository.save(userEntity);
        } catch (Exception e) {
            return ResponseDto.setFailed("Database Error!");
        }

        // 성공 시 success response 반환
        return ResponseDto.setSuccess("Sign Up Success!", null);
    }

    public ResponseDto<SignInResponseDto> signIn(SignInDto dto) {

        // 이메일과 비밀번호가 존재하면 true, 존재안하면 false를 반환
        String userEmail = dto.getUserEmail();
        String userPassword = dto.getUserPassword();
        try {
            boolean existed = userRepository.existsByUserEmailAndUserPassword(userEmail, userPassword);
            if(!existed) return ResponseDto.setFailed("Sign In Information Does Not Match");
        } catch (Exception error) {
            return ResponseDto.setFailed("Database Error");
        }

            UserEntity userEntity = null;
        try {
            userEntity = userRepository.findById(userEmail).get();
        } catch (Exception error) {
            return ResponseDto.setFailed("Database Error");
        }

        userEntity.setUserPassword("");

        // 토큰 생성
        String token = tokenProvider.create(userEmail);

        // 토큰 만료시간(1시간)
        int exprTime = 3600000;

        SignInResponseDto signInResponseDto = new SignInResponseDto(token, exprTime, userEntity);
        return ResponseDto.setSuccess("Sign In success", signInResponseDto);
    }
}
