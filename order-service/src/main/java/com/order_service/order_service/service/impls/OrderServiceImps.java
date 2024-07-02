package com.order_service.order_service.service.impls;

import com.order_service.order_service.client.InventoryFeignClient;
import com.order_service.order_service.config.WebClientConfig;
import com.order_service.order_service.dto.InventoryCheckList;
import com.order_service.order_service.dto.InventoryResponse;
import com.order_service.order_service.dto.OrderLineItemsDto;
import com.order_service.order_service.dto.OrderRequest;
import com.order_service.order_service.model.Order;
import com.order_service.order_service.model.OrderLineItems;
import com.order_service.order_service.repository.OrderRepository;
import com.order_service.order_service.service.OrderService;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;


@Service
public class OrderServiceImps implements OrderService {

    @Autowired
    OrderRepository orderRepository;


//    @Autowired
//    WebClientConfig webClientConfig;


    @Autowired
    InventoryFeignClient inventoryFeignClient;


    @Override
    public String placeOrder(OrderRequest orderRequest) throws Exception {
        Order order = new Order();
        order.setOrderNumber(UUID.randomUUID().toString());
        List<OrderLineItems> orderLineItemsList = orderRequest.getOrderLineItemsDtoList().stream().map(this::orderLineItemsDtoToOrderLineItems).toList();
        order.setOrderLineItemsList(orderLineItemsList);
        List<InventoryCheckList> inventoryCheckLists = new ArrayList<>();
        for(OrderLineItems orderLineItems : orderLineItemsList){
            inventoryCheckLists.add(new InventoryCheckList(orderLineItems.getSkuCode(),orderLineItems.getQuantity()));
        }

        try {
//            InventoryResponse[] inventoryResponses = webClientConfig.getWebClientConfig().build()
//                    .method(HttpMethod.POST)
//                    .uri("http://inventory-service/api/inventory/check-in-stock")
//                    .bodyValue(inventoryCheckLists)
//                    .retrieve()
//                    .bodyToMono(InventoryResponse[].class)
//                    .block();


            InventoryResponse[] inventoryResponses = inventoryFeignClient.isInStock(inventoryCheckLists).toArray(new InventoryResponse[0]);

            //List<InventoryResponse> responses = inventoryClient.isInStock(skuList);

            assert inventoryResponses != null;
            boolean allInStock = Arrays.stream(inventoryResponses).allMatch(InventoryResponse::isInStock);
            if(allInStock){
                orderRepository.save(order);
                return "Order Placed Successfully";
            }
        } catch (Exception e) {
            throw new Exception("Order Placed failed " + e.getMessage());
        }
        return  "Ordered item are not in stock";
    }

    private OrderLineItems orderLineItemsDtoToOrderLineItems(OrderLineItemsDto orderLineItemsDto) {
        return  OrderLineItems.builder()
                .price(orderLineItemsDto.getPrice())
                .skuCode(orderLineItemsDto.getSkuCode())
                .quantity(orderLineItemsDto.getQuantity())
                .build();
    }
}
