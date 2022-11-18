package com.onlinegrocerydeliverysystem.serviceimpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.onlinegrocerydeliverysystem.exceptions.OrderIdNotFoundException;
import com.onlinegrocerydeliverysystem.exceptions.ResourceNotFoundException;
import com.onlinegrocerydeliverysystem.exceptions.UserNotFoundException;
import com.onlinegrocerydeliverysystem.models.Order;
import com.onlinegrocerydeliverysystem.repository.OrderRepository;
import com.onlinegrocerydeliverysystem.repository.UserRepository;
import com.onlinegrocerydeliverysystem.service.OrderService;

/**
 * 
 * @see OrderServiceImpl
 * @version 1.0
 */
@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	UserRepository userRepository;
	@Autowired
	OrderRepository orderRepository;
	
	/**
	 * This method implements the viewOrder(userId, orderId) method of OrderService interface
	 * @param userId
	 * @param orderId
	 * @return
	 * @throws OrderIdNotFoundException
	 * @throws UserNotFoundException
	 * @throws ResourceNotFoundException
	 */
	
	@Override
	public List<Order> viewOrder(@PathVariable("userId") long userId, @PathVariable("orderId") long orderId) throws UserNotFoundException, ResourceNotFoundException, OrderIdNotFoundException
	{
		if(!userRepository.existsById(userId))
		{	
			System.out.println("It is invalid user id "+userId);
			throw new UserNotFoundException("Invalid user id");
		}
		else if(orderRepository.findById(orderId)==null)
		{
			System.out.println("It is invalid order id "+orderId);
			throw new OrderIdNotFoundException("Invalid order id");
		}
		else if(orderRepository.findByIdAndUserId(orderId,userId).isEmpty())
		{
			System.out.println("There is no order having orderId "+orderId+" which is found associated with the user");
			throw new ResourceNotFoundException("No order with orderId "+orderId+" found associated to this user");
		}
		else
		{
			System.out.println("Finding order by orderId & userId successful");
			return orderRepository.findByIdAndUserId(orderId,userId);
		}
	}
	
	/**
	 * This method implements the viewOrder(orderId) method of OrderService interface
	 * @param orderId
	 * @return list of orders
	 * @throws OrderIdNotFoundException
	 */
	
	@Override
	public List<Order> viewOrder(long orderId) throws OrderIdNotFoundException {
		if(orderRepository.findById(orderId)==null)
		{
			System.out.println("It is invalid order id "+orderId);
			throw new OrderIdNotFoundException("Invalid order id");
		}
		System.out.println("Finding order by orderId successful");
		return orderRepository.findAllById(orderId);
	}

	@Override
	public List<Order> viewAllOrders(long userId) throws UserNotFoundException {
		if(!userRepository.existsById(userId))
			throw new UserNotFoundException("Invalid user id");
		return orderRepository.findByUserId(userId);
	}
}
