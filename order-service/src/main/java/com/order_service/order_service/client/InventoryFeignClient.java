package com.order_service.order_service.client;


import com.order_service.order_service.dto.InventoryCheckList;
import com.order_service.order_service.dto.InventoryResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient("inventory-service")
@Component
public interface InventoryFeignClient {

    @PostMapping(value = "/api/inventory/check-in-stock",consumes = "application/json")
    public List<InventoryResponse> isInStock(@RequestBody List<InventoryCheckList> skuList);
}
