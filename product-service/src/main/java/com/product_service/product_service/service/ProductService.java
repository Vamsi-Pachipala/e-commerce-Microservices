package com.product_service.product_service.service;


import com.product_service.product_service.dto.ProductRequest;
import com.product_service.product_service.dto.ProductResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {
    String addProduct(ProductRequest productRequest);

    List<ProductResponse> getAllProducts();
}
