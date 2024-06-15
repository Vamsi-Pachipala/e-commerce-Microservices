package com.order_service.order_service.service;


import com.order_service.order_service.dto.OrderLineItemsDto;
import com.order_service.order_service.dto.OrderRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OrderService {
    String placeOrder(OrderRequest orderRequest) throws Exception;
}
