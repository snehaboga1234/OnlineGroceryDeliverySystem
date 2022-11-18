package com.onlinegrocerydeliverysystem.serviceimpl;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Date;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.onlinegrocerydeliverysystem.exceptions.OrderIdNotFoundException;
import com.onlinegrocerydeliverysystem.models.Order;
import com.onlinegrocerydeliverysystem.repository.OrderRepository;
import com.onlinegrocerydeliverysystem.serviceimpl.CardPaymentServiceImpl;

/**
 * Test Class for CardPaymentServiceImpl
 * 
 * @see CardPaymentServiceImpl
 * @version 1.0
 */
@ExtendWith(MockitoExtension.class)
class CardPaymentServiceImplTest {

	/**
	 * OrderRepository mock object.
	 */
	@Mock
	OrderRepository orderRepository;

	/**
	 * CardPaymentServiceImpl object.
	 */
	@InjectMocks
	CardPaymentServiceImpl cardPaymentService;

	/**
	 * Positive test case for makePayment method.
	 * 
	 * @throws OrderIdNotFoundException
	 */
	@Test
	void testMakePayment() throws OrderIdNotFoundException {
		Mockito.when(orderRepository.findById(1L))
				.thenReturn(Stream.of(new Order(1L, Date.valueOf("2022-04-26"))).collect(Collectors.toList()));
		assertEquals(1L, cardPaymentService.makePayment(1L).getOrderId());
	}

	/**
	 * Negative test case for makePayment method.
	 */
	@Test
	void testMakePaymentNegative() {
		Exception exception = assertThrows(OrderIdNotFoundException.class, () -> {
			cardPaymentService.makePayment(3L);
		});
		assertEquals("Invalid Order Id.", exception.getMessage());
	}
}
