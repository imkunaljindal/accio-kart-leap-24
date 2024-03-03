package com.example.acciokartservice.service.transfomer;

import com.example.acciokartservice.dto.response.OrderResponse;
import com.example.acciokartservice.model.OrderEntity;

public class OrderTransformer {

    public static OrderResponse prepareOrderResponse(OrderEntity orderEntity){
        return OrderResponse.builder()
                .orderId(orderEntity.getOrderId())
                .numberOfItems(orderEntity.getNumberOfItems())
                .created(orderEntity.getCreated())
                .totalValue(orderEntity.getTotalValue())
                .build();
    }
}
