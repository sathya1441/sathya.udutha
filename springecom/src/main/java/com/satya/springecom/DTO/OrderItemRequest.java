package com.satya.springecom.DTO;

public record OrderItemRequest(
    int productId,
    int quantity
) {

}
