package com.example.user_service.controller;


import com.example.user_service.dto.UserRegisterDto;
import com.example.user_service.dto.UserResponseDto;
import com.example.user_service.dto.userConfiReading;
import com.example.user_service.service.Serviceimpls;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
@Validated
public class UserController {

    @Autowired
    Serviceimpls serviceimpls;


    @Value("${build.version}")
    public String version;

    @Autowired
    Environment environment;


    @Autowired
    userConfiReading userConfiReading;

    @PostMapping("/register")
    public ResponseEntity<UserResponseDto> registerUser(@Valid @RequestBody UserRegisterDto userRegisterDto){
       return serviceimpls.registerUser(userRegisterDto);
    }

    @GetMapping("/get-version")
    public String getVersion(){
        return version;
    }
}
