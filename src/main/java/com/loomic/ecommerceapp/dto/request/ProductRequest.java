package com.loomic.ecommerceapp.dto.request;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class ProductRequest {
    @NotBlank
    private String name;
    @NotBlank
    private String category;
    @DecimalMin(value = "0.01")
    private BigDecimal price;

    private List<String> tags = new ArrayList<>();
}
