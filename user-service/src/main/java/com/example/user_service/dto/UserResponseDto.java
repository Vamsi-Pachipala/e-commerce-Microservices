package com.example.user_service.dto;

import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserResponseDto {

    private String name;

    private String mobileNumber;

    private String message;
}
