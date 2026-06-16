package com.loomic.ecommerceapp.controller;

import com.loomic.ecommerceapp.dto.request.CartRequest;
import com.loomic.ecommerceapp.dto.response.CartResponse;
import com.loomic.ecommerceapp.service.CartService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cart")
public class CartController {

    private final CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }
    @PostMapping
    public CartResponse createCart(){
        return cartService.createCart();
    }
    @PostMapping("/products")
    public CartResponse addProductToCart(@RequestBody @Valid CartRequest cartRequest){
        return cartService.addProductsToCart(cartRequest);
    }

    @DeleteMapping("/products")
    public CartResponse removeProductsFromCart(@RequestBody @Valid CartRequest cartRequest){
        return cartService.removeProductsFromCart(cartRequest);
    }

    @GetMapping("/{cartId}")
    public CartResponse getCartById(@PathVariable Long cartId){
        return cartService.getCartById(cartId);
    }

    @GetMapping
    public List<CartResponse> getAllCarts() {

        return cartService.getAllCarts();
    }
}
