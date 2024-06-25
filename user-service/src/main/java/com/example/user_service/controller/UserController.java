package com.example.user_service.controller;


import com.example.user_service.dto.UserRegisterDto;
import com.example.user_service.dto.UserResponseDto;
import com.example.user_service.service.Serviceimpls;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.core.env.Environment;

@RestController
@RequestMapping("/api/user")
@Validated
public class UserController {

    @Autowired
    Serviceimpls serviceimpls;


    @Autowired
    Environment environment;

    @PostMapping("/register")
    public ResponseEntity<UserResponseDto> registerUser(@Valid @RequestBody UserRegisterDto userRegisterDto){
       return serviceimpls.registerUser(userRegisterDto);
    }

    @GetMapping("/get-version")
    public String getVersion(){
        return environment.getProperty("JAVA_HOME");
    }
}
