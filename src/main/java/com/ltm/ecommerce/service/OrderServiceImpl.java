package com.ltm.ecommerce.service;

import org.springframework.stereotype.Service;

import com.ltm.ecommerce.beans.OrderBean;
import com.ltm.ecommerce.dto.OrderRequest;
import com.ltm.ecommerce.dto.OrderResponse;
import com.ltm.ecommerce.entity.Order;
import com.ltm.ecommerce.exception.OrderNotFoundException;
import com.ltm.ecommerce.repository.OrderRepository;

@Service
public class OrderServiceImpl implements OrderService {

	public final OrderRepository orderRepository;

	public OrderServiceImpl(OrderRepository repository) {
		this.orderRepository = repository;
	}

	@Override
	public OrderResponse getOrder(int id) {

		Order order = orderRepository.findById(id).
				orElseThrow(() -> new OrderNotFoundException ("Order not found with id :"+id));

		OrderResponse response = new OrderResponse();

		response.setOrderId(order.getOrderId());
		response.setCustomerName(order.getCustomerName());
		response.setProductName(order.getProductName());
		response.setQuantity(order.getQuantity());
		response.setAmount(order.getAmount());
		response.setOrderStatus(order.getOrderStatus());

		return response;
	}

	@Override
	public OrderResponse createOrder(OrderRequest request) {

		// DTO → Entity
		Order order = new Order();

		order.setCustomerName(request.getCustomerName());
		order.setProductName(request.getProductName());
		order.setQuantity(request.getQuantity());
		order.setAmount(request.getAmount());
		order.setOrderStatus(request.getOrderStatus());

		// Save Entity into database
		Order savedOrder = orderRepository.save(order);

		// Entity → Response DTO
		OrderResponse response = new OrderResponse();

		response.setOrderId(savedOrder.getOrderId());
		response.setCustomerName(savedOrder.getCustomerName());
		response.setProductName(savedOrder.getProductName());
		response.setQuantity(savedOrder.getQuantity());
		response.setAmount(savedOrder.getAmount());
		response.setOrderStatus(savedOrder.getOrderStatus());

		return response;
	}

	@Override
	public OrderResponse updateOrder(int id, OrderRequest request) {

		// 1. Find existing order
		Order order = orderRepository.findById(id).
				orElseThrow(() -> new OrderNotFoundException ("Order not found with id :"+id));
		
		// 2. Update the existing entity
		order.setCustomerName(request.getCustomerName());
		order.setProductName(request.getProductName());
		order.setQuantity(request.getQuantity());
		order.setAmount(request.getAmount());
		order.setOrderStatus(request.getOrderStatus());

		// 3. Save the updated entity
		Order updatedOrder = orderRepository.save(order);

		// 4. Entity → Response DTO
		OrderResponse response = new OrderResponse();

		response.setOrderId(updatedOrder.getOrderId());
		response.setCustomerName(updatedOrder.getCustomerName());
		response.setProductName(updatedOrder.getProductName());
		response.setQuantity(updatedOrder.getQuantity());
		response.setAmount(updatedOrder.getAmount());
		response.setOrderStatus(updatedOrder.getOrderStatus());

		return response;
	}

	@Override
	public void deleteOrder(int id) {
		orderRepository.deleteById(id);;
		
	}

}
