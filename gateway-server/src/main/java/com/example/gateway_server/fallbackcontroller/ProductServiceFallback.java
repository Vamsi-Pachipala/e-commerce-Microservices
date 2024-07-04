package com.example.gateway_server.fallbackcontroller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductServiceFallback {



    @GetMapping("/fallback/product")
    public String orderServiceFallback() {
        return "Product Service is currently unavailable. Please try again later.";
    }
}
