package com.loomic.ecommerceapp.service;

import com.loomic.ecommerceapp.dto.request.OrderRequest;
import com.loomic.ecommerceapp.dto.response.OrderResponse;

import java.util.List;

public interface OrderService {

    OrderResponse createOrder(OrderRequest orderRequest);

    OrderResponse getOrderById(Long orderId);

    List<OrderResponse> getAllOrders();
}
