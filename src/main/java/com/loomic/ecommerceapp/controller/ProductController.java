package com.loomic.ecommerceapp.controller;


import com.loomic.ecommerceapp.dto.request.ProductRequest;
import com.loomic.ecommerceapp.dto.response.ProductResponse;
import com.loomic.ecommerceapp.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public List<ProductResponse> createProducts(@RequestBody @Valid List<ProductRequest> requests){
        return productService.createProducts(requests);
    }

    @GetMapping
    public List<ProductResponse> getAllProducts(){
        return productService.getAllProducts();
    }

    @GetMapping("/{productID}")
    public ProductResponse getProductById(@PathVariable Long productId){
        return productService.getProductWithId(productId);
    }

    @PutMapping("/{productId}")
    public ProductResponse updateProduct(@PathVariable Long productId, @RequestBody @Valid ProductRequest request){
        return productService.updateProduct(productId, request);
    }

    @DeleteMapping("/{productId}")
    public void deleteProduct(@PathVariable Long productId){
        productService.deleteProduct(productId);
    }
}
