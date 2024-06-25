package com.example.user_service.dto;


import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "user")
public record userConfiReading(String message) {
}
