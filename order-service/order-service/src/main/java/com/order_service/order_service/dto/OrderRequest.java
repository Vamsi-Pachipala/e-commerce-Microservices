package com.order_service.order_service.dto;

import lombok.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OrderRequest {
    private List<OrderLineItemsDto> orderLineItemsDtoList;
}

