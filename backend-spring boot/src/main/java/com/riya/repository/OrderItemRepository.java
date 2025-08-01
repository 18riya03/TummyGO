package com.riya.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.riya.model.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

}
