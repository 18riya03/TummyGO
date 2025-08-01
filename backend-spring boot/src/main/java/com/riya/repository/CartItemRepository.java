package com.riya.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.riya.model.CartItem;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {


//    CartItem findByFoodIsContaining

}
