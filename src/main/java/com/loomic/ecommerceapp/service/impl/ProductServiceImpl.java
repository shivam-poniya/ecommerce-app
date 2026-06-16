package com.loomic.ecommerceapp.service.impl;

import com.loomic.ecommerceapp.dto.request.ProductRequest;
import com.loomic.ecommerceapp.dto.response.ProductResponse;
import com.loomic.ecommerceapp.entity.Product;
import com.loomic.ecommerceapp.mapper.ProductMapper;
import com.loomic.ecommerceapp.repository.ProductRepository;
import com.loomic.ecommerceapp.service.ProductService;
import com.loomic.ecommerceapp.util.UUIDGenerator;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<ProductResponse> createProducts(List<ProductRequest> requestList) {

        List<Product> products= requestList.stream().map(ProductMapper::toEntity).toList();
        products.forEach(p -> p.setProductId(UUIDGenerator.generateId()));

        List<Product> savedProducts = productRepository.saveAll(products);

        return savedProducts.stream().map(ProductMapper::toResponse).toList();
    }

    @Override
    public ProductResponse getProductWithId(Long productId) {
        Product product = productRepository.findById(productId).orElseThrow(() ->
                new RuntimeException(
                        "Product not found"
                ));
        return ProductMapper.toResponse(product);
    }

    @Override
    public List<ProductResponse> getAllProducts() {
        return productRepository.findAll()
                .stream()
                .map(ProductMapper::toResponse)
                .toList();
    }

    @Override
    public ProductResponse updateProduct(Long productId, ProductRequest request) {
        Product product = productRepository.findById(productId).orElseThrow(() ->
                new RuntimeException(
                        "Product not found"
                ));
        product.setName(request.getName());
        product.setCategory(request.getCategory());
        product.setPrice(request.getPrice());
        product.setTags(request.getTags());

        Product updatedProduct = productRepository.save(product);
        return ProductMapper.toResponse(updatedProduct);
    }

    @Override
    public void deleteProduct(Long productId) {
        Product product =
                productRepository.findById(productId)
                        .orElseThrow(() ->
                                new RuntimeException(
                                        "Product not found"
                                ));

        productRepository.delete(product);

    }
}
