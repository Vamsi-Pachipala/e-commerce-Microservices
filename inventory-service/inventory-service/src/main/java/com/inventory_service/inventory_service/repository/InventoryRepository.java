package com.inventory_service.inventory_service.repository;

import com.inventory_service.inventory_service.dto.InventoryCheckList;
import com.inventory_service.inventory_service.model.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface InventoryRepository extends JpaRepository<Inventory,Long> {

    Optional<List<Inventory>> findBySkuCodeIn(List<String> skuList);
}
