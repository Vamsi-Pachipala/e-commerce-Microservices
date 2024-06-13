package com.order_service.order_service.controller;


import com.order_service.order_service.dto.OrderLineItemsDto;
import com.order_service.order_service.dto.OrderRequest;
import com.order_service.order_service.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/order")
public class OrderController {


    @Autowired
    OrderService orderService;

    @PostMapping("/place")
    public ResponseEntity<String> placeOrder(@RequestBody OrderRequest orderRequest) throws Exception {
        String ans = orderService.placeOrder(orderRequest);
        return new ResponseEntity<>(ans, HttpStatus.CREATED);
    }
}
