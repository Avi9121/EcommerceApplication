package com.ltm.ecommerce.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class OrderRequest {
	@NotBlank(message = "Customer name is required")
	private String customerName;

	@NotBlank(message = "Product name is required")
	private String productName;

	@NotNull(message="Quantity is required")
	@Positive(message = "Quantity must be greater than 0")
	private Integer quantity;

	@NotNull(message = "Amount is required")
	@Positive(message = "Amount must be greater than 0")
	private Double amount;

	@NotBlank(message = "Order status is required")
	private String orderStatus;

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	@Override
	public String toString() {
		return "OrderRequest [customerName=" + customerName + ", productName=" + productName + ", quantity=" + quantity
				+ ", amount=" + amount + ", orderStatus=" + orderStatus + "]";
	}

}
