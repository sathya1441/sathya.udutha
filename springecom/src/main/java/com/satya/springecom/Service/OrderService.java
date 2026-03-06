package com.satya.springecom.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.satya.springecom.DTO.OrderItemRequest;
import com.satya.springecom.DTO.OrderItemResponse;
import com.satya.springecom.DTO.OrderRequest;
import com.satya.springecom.DTO.OrderResponse;
import com.satya.springecom.Models.OrderItems;
import com.satya.springecom.Models.Orders;
import com.satya.springecom.Models.Product;
import com.satya.springecom.Repo.OrderRepository;
import com.satya.springecom.Repo.ProductRepository;

@Service
public class OrderService {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    OrderRepository orderRepository;

    public OrderResponse placeOrder(OrderRequest orderRequest) {
        Orders order = new Orders();
        order.setOrderId("ORD" + UUID.randomUUID().toString().substring(0,8).toUpperCase());
        order.setCustomerName(orderRequest.customerName());
        order.setCustomerEmail(orderRequest.customerEmail());
        order.setOrderDate(LocalDate.now());
        order.setStatus("PLACED");
        List<OrderItems> orderItems = new ArrayList<>();
        for(OrderItemRequest itemRequest : orderRequest.items()) {
            OrderItems item = new OrderItems();
            Product product = productRepository.findById(itemRequest.productId()).orElseThrow(() -> new RuntimeException("Product not found with ID: " + itemRequest.productId()));
            product.setStockQuantity(product.getStockQuantity() - itemRequest.quantity());
            productRepository.save(product);
            item.setProduct(product);
            item.setQuantity(itemRequest.quantity());
            item.setTotalPrice(product.getPrice().multiply(java.math.BigDecimal.valueOf(itemRequest.quantity())));
            item.setOrder(order);
            orderItems.add(item);
        }
        order.setItems(orderItems);
        Orders savedOrder = orderRepository.save(order);
        List<OrderItemResponse> itemResponses = new ArrayList<>();
        for(OrderItems items : order.getItems()) {
            OrderItemResponse itemResponse = new OrderItemResponse(
                items.getProduct().getName(),
                items.getQuantity(),
                items.getTotalPrice()
            );
            itemResponses.add(itemResponse);
        }
        OrderResponse orderResponse = new OrderResponse(
            savedOrder.getOrderId(),
            savedOrder.getCustomerName(),
            savedOrder.getCustomerEmail(),
            savedOrder.getOrderDate(),
            savedOrder.getStatus(),
            itemResponses
        );
        return orderResponse;
    }
    public List<OrderResponse> getOrders() {
        List<OrderResponse> orderResponseList = new ArrayList<>();
        List<Orders> allOrders = orderRepository.findAll();
        for(Orders order : allOrders){
            List<OrderItemResponse> itemResponseList = new ArrayList<>();
            for(OrderItems items : order.getItems()){
                OrderItemResponse itemResponse = new OrderItemResponse(
                    items.getProduct().getName(),
                    items.getQuantity(),
                    items.getTotalPrice()
                );
                itemResponseList.add(itemResponse);
            }
            OrderResponse orderResponse = new OrderResponse(
                order.getOrderId(),
                order.getCustomerName(),
                order.getCustomerEmail(),
                order.getOrderDate(),
                order.getStatus(),
                itemResponseList
            );
            orderResponseList.add(orderResponse);
        }
        return orderResponseList;
    }
}