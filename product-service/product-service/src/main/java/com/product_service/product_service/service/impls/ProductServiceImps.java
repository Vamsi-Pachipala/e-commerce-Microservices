package com.product_service.product_service.service.impls;

import com.product_service.product_service.dto.ProductRequest;
import com.product_service.product_service.dto.ProductResponse;
import com.product_service.product_service.model.Product;
import com.product_service.product_service.repository.ProductRepository;
import com.product_service.product_service.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


@Service
public class ProductServiceImps implements ProductService {

    @Autowired
    ProductRepository productRepository;

    @Override
    public String addProduct(ProductRequest productRequest) {
        Product product = Product.builder()
                .id(UUID.randomUUID().toString())
                .name(productRequest.getName())
                .description(productRequest.getDescription())
                .price(productRequest.getPrice())
                .build();
        productRepository.save(product);
        return "Product added successfully";
    }

    @Override
    public List<ProductResponse> getAllProducts() {
        List<Product> productList = productRepository.findAll();
        return productList.stream().map(this::productToProductResponse).toList();
    }

    private ProductResponse productToProductResponse(Product product) {
        return ProductResponse.builder()
                .name(product.getName())
                .description(product.getDescription())
                .id(product.getId())
                .price(product.getPrice())
                .build();
    }
}
