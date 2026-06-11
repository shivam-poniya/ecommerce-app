package com.loomic.ecommerceapp.dto.response;


import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
public class ProductResponse {
    private Long productId;
    private String name;
    private String category;
    private BigDecimal price;
    private List<String> tags;
}
