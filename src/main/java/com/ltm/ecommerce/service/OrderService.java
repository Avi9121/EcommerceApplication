package com.ltm.ecommerce.service;

import com.ltm.ecommerce.beans.OrderBean;
import com.ltm.ecommerce.dto.OrderRequest;
import com.ltm.ecommerce.dto.OrderResponse;

public interface OrderService {

	OrderResponse getOrder(int id);

	OrderResponse createOrder(OrderRequest request);

	OrderResponse updateOrder(int id, OrderRequest request);

	void deleteOrder(int id);
}
