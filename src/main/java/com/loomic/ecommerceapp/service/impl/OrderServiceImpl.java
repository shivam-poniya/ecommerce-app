package com.loomic.ecommerceapp.service.impl;

import com.loomic.ecommerceapp.dto.request.OrderRequest;
import com.loomic.ecommerceapp.dto.response.OrderResponse;
import com.loomic.ecommerceapp.entity.Cart;
import com.loomic.ecommerceapp.entity.CartStatus;
import com.loomic.ecommerceapp.entity.OrderEntity;
import com.loomic.ecommerceapp.mapper.OrderMapper;
import com.loomic.ecommerceapp.repository.CartRepository;
import com.loomic.ecommerceapp.repository.OrderRepository;
import com.loomic.ecommerceapp.service.OrderService;
import com.loomic.ecommerceapp.util.TransactionIdGenerator;
import com.loomic.ecommerceapp.util.UUIDGenerator;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final CartRepository cartRepository;

    public OrderServiceImpl(OrderRepository orderRepository, CartRepository cartRepository) {
        this.orderRepository = orderRepository;
        this.cartRepository = cartRepository;
    }

    @Override
    public OrderResponse createOrder(OrderRequest orderRequest){
        Cart cart = cartRepository.findById(orderRequest.getCartId()).orElseThrow(() -> new RuntimeException("Cart not found!"));
        if (cart.getCartStatus()== CartStatus.ORDERED) {
            throw new RuntimeException("Cart already ordered");
        }
        if (cart.getProducts().isEmpty()) {
            throw new RuntimeException(
                    "Cart is empty"
            );
        }
        OrderEntity order = new OrderEntity();
        order.setOrderId(UUIDGenerator.generateId());
        order.setTransactionId(TransactionIdGenerator.generateTxnId());
        order.setCartId(cart.getCartId());
        order.setProducts(new HashSet<>(cart.getProducts()));

        OrderEntity savedOrder = orderRepository.save(order);
        cart.setCartStatus(CartStatus.ORDERED);
        cartRepository.save(cart);

        return OrderMapper.toResponse(savedOrder);
    }

    @Override
    public OrderResponse getOrderById(Long orderId) {
        OrderEntity order =orderRepository.findById(orderId)
                        .orElseThrow(() ->new RuntimeException("Order not found"));

        return OrderMapper.toResponse(order);
    }

    @Override
    public List<OrderResponse> getAllOrders() {
        return orderRepository.findAll()
                .stream()
                .map(OrderMapper::toResponse)
                .toList();
    }
}
