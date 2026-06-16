package com.loomic.ecommerceapp.service.impl;

import com.loomic.ecommerceapp.dto.request.CartRequest;
import com.loomic.ecommerceapp.dto.response.CartResponse;
import com.loomic.ecommerceapp.entity.Cart;
import com.loomic.ecommerceapp.entity.CartStatus;
import com.loomic.ecommerceapp.entity.Product;
import com.loomic.ecommerceapp.mapper.CartMapper;
import com.loomic.ecommerceapp.repository.CartRepository;
import com.loomic.ecommerceapp.repository.ProductRepository;
import com.loomic.ecommerceapp.service.CartService;
import com.loomic.ecommerceapp.util.UUIDGenerator;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartServiceImpl implements CartService {

    private final CartRepository cartRepository;
    private final ProductRepository productRepository;

    public CartServiceImpl(CartRepository cartRepository, ProductRepository productRepository) {
        this.cartRepository = cartRepository;
        this.productRepository = productRepository;
    }

    @Override
    public CartResponse createCart() {
        Cart cart = new Cart();

        cart.setCartId(UUIDGenerator.generateId());
        cart.setCartStatus(CartStatus.ACTIVE);

        Cart savedCart = cartRepository.save(cart);

        return CartMapper.toResponse(savedCart);
    }

    @Override
    public CartResponse getCartById(Long cartId) {
        Cart cart = cartRepository.findById(cartId)
                .orElseThrow(() -> new RuntimeException("Cart does not exist !"));

        return CartMapper.toResponse(cart);
    }

    @Override
    public List<CartResponse> getAllCarts(){
        return cartRepository.findAll().stream().map(CartMapper::toResponse).toList();
    }

    @Override
    public CartResponse addProductsToCart(CartRequest cartRequest){
        Cart cart = cartRepository.findById(cartRequest.getCartId())
                .orElseThrow(()-> new RuntimeException("Cart not found!"));

        if (cart.getCartStatus().equals(CartStatus.ORDERED)) {
            throw new RuntimeException("Cannot modify ordered cart");
        }

        List<Product> products = productRepository.findAllById(cartRequest.getProductIds());
        cart.getProducts().addAll(products);

        Cart updatedCart = cartRepository.save(cart);

        return CartMapper.toResponse(updatedCart);
    }

    @Override
    public CartResponse removeProductsFromCart(CartRequest cartRequest){
        Cart cart = cartRepository.findById(cartRequest.getCartId())
                .orElseThrow(()-> new RuntimeException("Cart not found!"));

        if (cart.getCartStatus().equals(CartStatus.ORDERED)) {
            throw new RuntimeException("Cannot modify ordered cart");
        }

        cart.getProducts().removeIf(p -> cartRequest.getProductIds().contains(p.getProductId()));

        Cart updatedCart = cartRepository.save(cart);
        return CartMapper.toResponse(updatedCart);
    }
}
