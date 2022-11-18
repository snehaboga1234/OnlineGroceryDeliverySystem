package com.onlinegrocerydeliverysystem.service;
import java.util.List;

import org.springframework.stereotype.Service;

import com.onlinegrocerydeliverysystem.exceptions.OrderIdNotFoundException;
import com.onlinegrocerydeliverysystem.exceptions.ResourceNotFoundException;
import com.onlinegrocerydeliverysystem.exceptions.UserNotFoundException;
import com.onlinegrocerydeliverysystem.models.Order;

/**
 * see OrderService
 * @version 1.0
 *
 */

@Service
public interface OrderService {
	
	/**
	 * This method return all the orders at admin level based on orderId
	 * @param orderId
	 * @return list of orders
	 * @throws OrderIdNotFoundException
	 */
	public List<Order> viewOrder(long orderId) throws OrderIdNotFoundException;
	
	/**
	 * This method return all the orders at user level based on userId and orderId
	 * @param userId
	 * @param orderId
	 * @return
	 * @throws OrderIdNotFoundException
	 * @throws UserNotFoundException
	 * @throws ResourceNotFoundException
	 */
	public List<Order> viewOrder(long userId, long orderId) throws OrderIdNotFoundException, UserNotFoundException, ResourceNotFoundException;

	public List<Order> viewAllOrders(long userId) throws UserNotFoundException;
}
