package com.example.user_service.dto;


import jakarta.validation.constraints.*;
import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserRegisterDto {

    @NotEmpty(message = "name should not be empty value")
    @Size(min = 3,max = 30,message = "name of the customer should be 3 and 30")
    private String name;

    @Min(0)
    @Max(100)
    private int age;

    @NotNull
    @Size(min = 10, max = 10)
    @Digits(integer = 10, fraction = 0)
    private String mobileNumber;

    @Email(message = "please provide valid email")
    private String email;
}
