package com.inventory_service.inventory_service.controller;


import com.inventory_service.inventory_service.dto.InventoryCheckList;
import com.inventory_service.inventory_service.dto.InventoryResponse;
import com.inventory_service.inventory_service.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/inventory")
public class InventoryController {

    @Autowired
    InventoryService inventoryService;


    @PostMapping("/check-in-stock")
    public List<InventoryResponse> isInStock(@RequestBody List<InventoryCheckList> skuList){

        return inventoryService.isInStock(skuList);

    }
}
