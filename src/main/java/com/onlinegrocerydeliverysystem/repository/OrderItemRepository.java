package com.onlinegrocerydeliverysystem.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.onlinegrocerydeliverysystem.models.OrderItem;

/**
 * This is the OrderItem Repository Interface
 * OrderItem Repository Interface extends Jpa Repository
 */

public interface OrderItemRepository extends JpaRepository<OrderItem, Long>{

}
