package com.loomic.ecommerceapp.service;

import com.loomic.ecommerceapp.dto.request.CartRequest;
import com.loomic.ecommerceapp.dto.response.CartResponse;

import java.util.List;

public interface CartService {

    CartResponse createCart();

    CartResponse getCartById(Long cartId);

    CartResponse addProductsToCart(CartRequest request);

    CartResponse removeProductsFromCart(CartRequest cartRequest);

    List<CartResponse> getAllCarts();
}
