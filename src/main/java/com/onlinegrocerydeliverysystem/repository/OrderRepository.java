package com.onlinegrocerydeliverysystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.onlinegrocerydeliverysystem.models.Order;

/**
 * This is the Order Repository Interface
 * Order Repository Interface extends Jpa Repository
 */

public interface OrderRepository extends JpaRepository<Order, Long> {
	
	/**
	 * This method returns all the orders based on orderId
	 * @param id
	 * @return
	 */
	public List<Order> findAllById(long id);

	/**
	 * This method return first order with provided orderId
	 * @param id
	 * @return
	 */
	public List<Order> findById(long id);

	/**
	 * This method returns all the orders based on orderId and userId
	 * @param orderId
	 * @param userId
	 * @return
	 */
	public List<Order> findByIdAndUserId(long orderId, long userId);

	public List<Order> findByUserId(long userId);
	
	
}
