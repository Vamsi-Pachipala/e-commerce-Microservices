package com.example.user_service.controller;


import com.example.user_service.dto.UserRegisterDto;
import com.example.user_service.dto.UserResponseDto;
import com.example.user_service.service.Serviceimpls;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
@Validated
public class UserController {

    @Autowired
    Serviceimpls serviceimpls;

    @PostMapping("/register")
    public ResponseEntity<UserResponseDto> registerUser(@Valid @RequestBody UserRegisterDto userRegisterDto){
       return serviceimpls.registerUser(userRegisterDto);
    }
}
