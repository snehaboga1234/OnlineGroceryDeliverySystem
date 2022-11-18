package com.onlinegrocerydeliverysystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.onlinegrocerydeliverysystem.dto.BillDto;
import com.onlinegrocerydeliverysystem.exceptions.OrderIdNotFoundException;
import com.onlinegrocerydeliverysystem.models.CardDetails;
import com.onlinegrocerydeliverysystem.service.CardPaymentService;

/**
 * Controller class for Card Payment.
 * 
 * @see CardPaymentController
 * @version 1.0
 */
@CrossOrigin("http://localhost:4200/")
@RestController
public class CardPaymentController {

	/**
	 * CardPaymentService object.
	 */
	@Autowired
	private CardPaymentService cardPaymentService;

	/**
	 * Controller method for making payment through card.
	 * 
	 * @param orderId
	 * @param cardDetails
	 * @return
	 * @throws OrderIdNotFoundException
	 */
	@PostMapping("/make-payment/{order_id}")
	ResponseEntity<BillDto> makePayment(@PathVariable("order_id") long orderId, @RequestBody CardDetails cardDetails)
			throws OrderIdNotFoundException {
		return new ResponseEntity<>(new BillDto(cardPaymentService.makePayment(orderId)), HttpStatus.OK);
	}
}
