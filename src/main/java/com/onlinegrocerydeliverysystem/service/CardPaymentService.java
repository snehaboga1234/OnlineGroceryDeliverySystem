package com.onlinegrocerydeliverysystem.service;

import com.onlinegrocerydeliverysystem.exceptions.OrderIdNotFoundException;
import com.onlinegrocerydeliverysystem.models.Bill;

/**
 * Service interface to define makePayment method.
 * 
 * @see CardPaymentService
 * @version 1.0
 */
public interface CardPaymentService {

	public Bill makePayment(long orderId) throws OrderIdNotFoundException;

}
