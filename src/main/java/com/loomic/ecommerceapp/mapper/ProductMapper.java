package com.loomic.ecommerceapp.mapper;

import com.loomic.ecommerceapp.dto.request.ProductRequest;
import com.loomic.ecommerceapp.dto.response.ProductResponse;
import com.loomic.ecommerceapp.entity.Product;

import java.util.Arrays;

public class ProductMapper {

    public static Product toEntity(ProductRequest request){
        Product product = new Product();

        product.setName(request.getName());
        product.setCategory(request.getCategory());
        product.setPrice(request.getPrice());
        product.setTags(request.getTags());

        return product;
    }

    public static ProductResponse toResponse(Product product){
        ProductResponse response = new ProductResponse();

        response.setProductId(product.getProductId());
        response.setName(product.getName());
        response.setPrice(product.getPrice());
        response.setTags(product.getTags());
        response.setCategory(product.getCategory());

        return response;
    }
}
