package com.onlinegrocerydeliverysystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onlinegrocerydeliverysystem.exceptions.OrderIdNotFoundException;
import com.onlinegrocerydeliverysystem.exceptions.ResourceNotFoundException;
import com.onlinegrocerydeliverysystem.exceptions.UserNotFoundException;
import com.onlinegrocerydeliverysystem.models.Order;
import com.onlinegrocerydeliverysystem.service.OrderService;

/**
 * 
 * @see OrderController
 * @version 1.0
 *
 */
@CrossOrigin("http://localhost:4200/")
@RestController
@RequestMapping("/orders")
public class OrderController {

	@Autowired
	OrderService orderService;

	/**
	 * This method is to view orders at admin level
	 * 
	 * @param orderId
	 * @returns list of items ordered
	 */
	@GetMapping("/{orderId}")
	public List<Order> viewOrder(@PathVariable("orderId") long orderId) throws OrderIdNotFoundException {
		return orderService.viewOrder(orderId);
	}

	/**
	 * This method is to view orders at user level
	 * 
	 * @param userId
	 * @param orderId
	 * @returns list of items ordered
	 */
	@GetMapping("/{userId}/{orderId}")
	public List<Order> viewOrder(@PathVariable("userId") long userId, @PathVariable("orderId") long orderId)
			throws UserNotFoundException, ResourceNotFoundException, OrderIdNotFoundException {
		return orderService.viewOrder(userId, orderId);
	}

	@GetMapping("/allOrders/{userId}")
	public List<Order> viewAllOrders(@PathVariable("userId") long userId) throws UserNotFoundException {
		return orderService.viewAllOrders(userId);
	}

}
