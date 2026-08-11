package com.ltm.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ltm.ecommerce.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Integer>{

}
