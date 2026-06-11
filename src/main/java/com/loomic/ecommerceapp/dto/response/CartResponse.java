package com.loomic.ecommerceapp.dto.response;

import com.loomic.ecommerceapp.entity.CartStatus;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class CartResponse {

    private Long cartId;

    private CartStatus cartStatus;

    private List<ProductResponse> productResponseList = new ArrayList<>();
}
