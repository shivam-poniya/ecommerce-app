package com.loomic.ecommerceapp.mapper;

import com.loomic.ecommerceapp.dto.response.OrderResponse;
import com.loomic.ecommerceapp.dto.response.ProductResponse;
import com.loomic.ecommerceapp.entity.OrderEntity;

import java.util.List;

public final class OrderMapper {

    private OrderMapper() {
    }

    public static OrderResponse toResponse(
            OrderEntity order) {

        OrderResponse response =
                new OrderResponse();

        response.setOrderId(order.getOrderId());
        response.setTransactionId(
                order.getTransactionId());

        response.setCartId(order.getCartId());

        List<ProductResponse> products =
                order.getProducts()
                        .stream()
                        .map(ProductMapper::toResponse)
                        .toList();

        response.setProductResponseList(products);

        return response;
    }
}