package com.ltm.ecommerce.controller;

import org.springframework.web.bind.annotation.*;

import com.ltm.ecommerce.beans.OrderBean;
import com.ltm.ecommerce.dto.OrderRequest;
import com.ltm.ecommerce.dto.OrderResponse;
import com.ltm.ecommerce.service.OrderService;

import jakarta.validation.Valid;

@RestController
public class OrderController {

	private final OrderService orderService;

	public OrderController(OrderService orderService) {
		this.orderService = orderService;
	}

	@GetMapping("/orders/{id}")
	public OrderResponse getOrder(@PathVariable int id) {

		return orderService.getOrder(id);

	}

	@PostMapping("/orders")
	public OrderResponse createOrder(@Valid @RequestBody OrderRequest request) {
		return orderService.createOrder(request);
	}

	@PutMapping("/orders/{id}")
	public OrderResponse updateOrder(@PathVariable int id, @RequestBody OrderRequest request) {

		return orderService.updateOrder(id, request);
	}

	@DeleteMapping("/orders/{id}")
	public void deleteOrder(@PathVariable int id) {
		orderService.deleteOrder(id);

	}

	@GetMapping("/test-error")
	public String testError() {
		int result = 10 / 0;
		return "Success";
	}

}