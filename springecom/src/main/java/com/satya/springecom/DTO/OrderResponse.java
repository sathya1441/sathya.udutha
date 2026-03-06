package com.satya.springecom.DTO;

import java.time.LocalDate;
import java.util.List;

public record OrderResponse(
    String orderId,
    String customerName,
    String customerEmail,
    LocalDate orderDate,
    String status,
    List<OrderItemResponse> items
) {

}
