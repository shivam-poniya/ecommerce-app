package com.loomic.ecommerceapp.service;

import com.loomic.ecommerceapp.dto.request.ProductRequest;
import com.loomic.ecommerceapp.dto.response.ProductResponse;
import com.loomic.ecommerceapp.entity.Product;

import java.util.List;

public interface ProductService {

    List<ProductResponse> createProducts(List<ProductRequest> requestList);
    ProductResponse getProductWithId(Long productId);
    List<ProductResponse> getAllProducts();
    ProductResponse updateProduct(Long productId, ProductRequest request);
    void deleteProduct(Long productId);





}
