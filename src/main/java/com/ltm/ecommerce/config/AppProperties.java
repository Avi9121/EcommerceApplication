package com.ltm.ecommerce.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
@Component
@ConfigurationProperties(prefix = "app")
public class AppProperties {

	private String name;
	private int discount;
	private String currency;
	private int maxOrders;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getDiscount() {
		return discount;
	}
	public void setDiscount(int discount) {
		this.discount = discount;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public int getMaxOrders() {
		return maxOrders;
	}
	public void setMaxOrders(int maxOrders) {
		this.maxOrders = maxOrders;
	}
	
	

}
