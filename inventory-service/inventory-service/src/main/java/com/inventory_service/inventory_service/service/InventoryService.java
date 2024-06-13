package com.inventory_service.inventory_service.service;

import com.inventory_service.inventory_service.dto.InventoryCheckList;
import com.inventory_service.inventory_service.dto.InventoryResponse;
import com.inventory_service.inventory_service.model.Inventory;
import com.inventory_service.inventory_service.repository.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Service
public class InventoryService {


    @Autowired
    InventoryRepository inventoryRepository;

    public List<InventoryResponse> isInStock(List<InventoryCheckList> skuList){

        List<String> skuCodeList = skuList.stream().map(InventoryCheckList::getSkuCode).toList();
        Optional<List<Inventory>> inventoryList = inventoryRepository.findBySkuCodeIn(skuCodeList);
        List<InventoryResponse> inventoryResponseList = new ArrayList<>();

        HashMap<String,Integer> hashMap = new HashMap<>();

        if(inventoryList.isPresent()){
            for(Inventory inventory:inventoryList.get()){
                hashMap.put(inventory.getSkuCode(),inventory.getQuantity());
            }
        }
        for(InventoryCheckList inventoryCheckList:skuList){
            String skuCode = inventoryCheckList.getSkuCode();
            int quantity = inventoryCheckList.getQuantity();
            int stock = hashMap.get(skuCode);
            inventoryResponseList.add(new InventoryResponse(skuCode,stock>=quantity));
        }
        return inventoryResponseList;
    }

}
