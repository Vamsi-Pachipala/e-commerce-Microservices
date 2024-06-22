package com.example.user_service.service;


import com.example.user_service.dto.UserRegisterDto;
import com.example.user_service.dto.UserResponseDto;
import com.example.user_service.model.User;
import com.example.user_service.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class Serviceimpls {

    @Autowired
    UserRepository userRepository;


    public ResponseEntity<UserResponseDto> registerUser(UserRegisterDto userRegisterDto){

        User user = User.builder()
                        .age(userRegisterDto.getAge())
                        .email(userRegisterDto.getEmail())
                        .name(userRegisterDto.getName())
                        .mobileNumber(userRegisterDto.getMobileNumber())
                        .build();

       User savedUser =  userRepository.save(user);
        UserResponseDto userResponseDto = UserResponseDto.builder()
                .mobileNumber(savedUser.getMobileNumber())
                .name(savedUser.getName())
                .message("Greeting!! "+savedUser.getName()+" register successfully")
                .build();
        return new ResponseEntity<>(userResponseDto, HttpStatus.CREATED);
    }
}
