package com.product_service.product_service.model;
import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Product {
    @Id
    @Column(name = "id")
    private String id;
    private String name;
    private String description;
    private BigDecimal price;
}