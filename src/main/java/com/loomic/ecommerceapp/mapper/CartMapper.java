package com.loomic.ecommerceapp.mapper;

import com.loomic.ecommerceapp.dto.response.CartResponse;
import com.loomic.ecommerceapp.dto.response.ProductResponse;
import com.loomic.ecommerceapp.entity.Cart;

import java.util.List;

public final class CartMapper {

    private CartMapper() {
    }

    public static CartResponse toResponse(Cart cart) {

        CartResponse response = new CartResponse();

        response.setCartId(cart.getCartId());
        response.setCartStatus(cart.getCartStatus());

       List<ProductResponse> products =
                cart.getProducts()
               .stream()
               .map(ProductMapper::toResponse)
               .toList();

        response.setProductResponseList(products);

        return response;
    }
}