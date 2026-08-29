package com.ltm.ecommerce.controller;

import org.springframework.web.bind.annotation.*;

import com.ltm.ecommerce.dto.OrderRequest;
import com.ltm.ecommerce.dto.OrderResponse;
import com.ltm.ecommerce.service.OrderService;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;

@SecurityRequirement(name = "bearerAuth")
@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/{id}")
    public OrderResponse getOrder(@PathVariable int id) {

        return orderService.getOrder(id);
    }

    @PostMapping
    public OrderResponse createOrder(
            @Valid @RequestBody OrderRequest request) {

        return orderService.createOrder(request);
    }

    @PutMapping("/{id}")
    public OrderResponse updateOrder(
            @PathVariable int id,
            @RequestBody OrderRequest request) {

        return orderService.updateOrder(id, request);
    }

    @DeleteMapping("/{id}")
    public void deleteOrder(@PathVariable int id) {

        orderService.deleteOrder(id);
    }

    @GetMapping("/test-error")
    public String testError() {

        int result = 10 / 0;

        return "Success";
    }
}