package com.onlinegrocerydeliverysystem.serviceimpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlinegrocerydeliverysystem.exceptions.OrderIdNotFoundException;
import com.onlinegrocerydeliverysystem.models.Bill;
import com.onlinegrocerydeliverysystem.models.Order;
import com.onlinegrocerydeliverysystem.repository.OrderRepository;
import com.onlinegrocerydeliverysystem.service.CardPaymentService;

/**
 * Service class for payment through card.
 * 
 * @see CardPaymentServiceImpl
 * @version 1.0
 */
@Service
public class CardPaymentServiceImpl implements CardPaymentService {

	/**
	 * Order Repository object
	 */
	@Autowired
	private OrderRepository orderRepository;

	/**
	 * Method to make payment for a particular order.
	 * 
	 * @param orderId
	 * @return Bill
	 */
	@Override
	public Bill makePayment(long orderId) throws OrderIdNotFoundException {
		List<Order> orders = orderRepository.findById(orderId);
		if (orders.isEmpty())
			throw new OrderIdNotFoundException("Invalid Order Id.");
		Order order = orders.get(0);
		return new Bill(orderId, order.getOrderItems(), order.getTotalPrice(), "Paid");
	}

}
