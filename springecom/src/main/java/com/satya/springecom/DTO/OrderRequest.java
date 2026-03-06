package com.satya.springecom.DTO;

import java.util.List;

public record OrderRequest(
    String customerName,
    String customerEmail,
    List<OrderItemRequest> items
) {

}
