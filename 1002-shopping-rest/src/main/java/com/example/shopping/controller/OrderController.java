package com.example.shopping.controller;

import com.example.shopping.entity.Order;
import com.example.shopping.entity.OrderItem;
import com.example.shopping.service.OrderMaintenanceService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderController {
    private final OrderMaintenanceService orderMaintenanceService;

    OrderController(OrderMaintenanceService orderMaintenanceService) {
        this.orderMaintenanceService = orderMaintenanceService;
    }

    @GetMapping("orders")
    public List<Order> getOrders() {
        return orderMaintenanceService.findAll();
    }

    @GetMapping("orders/{orderId}")
    public Order getOrderDetail(@PathVariable String orderId) {
        return this.orderMaintenanceService.findById(orderId);
    }
}
