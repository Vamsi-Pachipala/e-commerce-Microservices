package com.inventory_service.inventory_service;

import com.inventory_service.inventory_service.dto.InventoryResponse;
import com.inventory_service.inventory_service.model.Inventory;
import com.inventory_service.inventory_service.repository.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class InventoryServiceApplication {

	@Autowired
	InventoryRepository inventoryRepository;

	public static void main(String[] args) {
		SpringApplication.run(InventoryServiceApplication.class, args);
	}

	@Bean
	public CommandLineRunner loadData(){
		return args -> {
			Inventory inventory = new Inventory();
			inventory.setSkuCode("iphone");
			inventory.setQuantity(2);
			inventoryRepository.save(inventory);

			Inventory inventory1 = new Inventory();
			inventory1.setQuantity(2);
			inventory1.setSkuCode("Android");
			inventoryRepository.save(inventory1);
		};
	}

}
