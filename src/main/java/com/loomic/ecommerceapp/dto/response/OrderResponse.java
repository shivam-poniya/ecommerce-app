package com.loomic.ecommerceapp.dto.response;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@JsonPropertyOrder({
        "orderId",
        "transactionId",
        "cartId",
        "productsList",
})
@Getter
@Setter
public class OrderResponse {

    private Long orderId;

    private String transactionId;

    private Long cartId;

    private List<ProductResponse> productsList = new ArrayList<>();
}
