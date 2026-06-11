package com.loomic.ecommerceapp.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CartRequest {
    @NotNull
    private Long cartId;
    private List<Long> productIds;
}
