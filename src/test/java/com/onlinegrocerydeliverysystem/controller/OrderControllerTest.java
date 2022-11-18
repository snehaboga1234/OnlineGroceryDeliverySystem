package com.onlinegrocerydeliverysystem.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.onlinegrocerydeliverysystem.exceptions.OrderIdNotFoundException;
import com.onlinegrocerydeliverysystem.exceptions.ResourceNotFoundException;
import com.onlinegrocerydeliverysystem.exceptions.UserNotFoundException;
import com.onlinegrocerydeliverysystem.models.Order;
import com.onlinegrocerydeliverysystem.models.OrderItem;
import com.onlinegrocerydeliverysystem.models.Product;
import com.onlinegrocerydeliverysystem.models.User;
import com.onlinegrocerydeliverysystem.service.OrderService;

/**
 * @see OrderControllerTest
 * @version 1.0
 *
 */
@ExtendWith(MockitoExtension.class)
class OrderControllerTest {

	@Mock
	OrderService orderService;
	@InjectMocks
	private OrderController orderController;

	User user;
	Product product1;
	Product product2;
	Order order;
	OrderItem orderItem1;
	OrderItem orderItem2;
	List<OrderItem> items;
	List<Order> orders;
	Optional<User> optionalUser;

	@BeforeEach
	void setUp() throws OrderIdNotFoundException, UserNotFoundException, ResourceNotFoundException {
		user = new User();
		user.setEmailId("kd147953@gmail.com");
		user.setFirstName("Kaushik");
		user.setId(1L);
		user.setLastName("Didwania");
		user.setPassword("Kd147953@");
		user.setPhoneNumber(1234567890L);
		product1 = new Product("Apple", 20, 100, "Fruits");
		product1.setProductId(1L);
		product2 = new Product("Mango", 30, 100, "Fruits");
		product2.setProductId(2L);
		order = new Order();
		order.setId(1);
		orderItem1 = new OrderItem();
		orderItem1.setOrderItemId(1);
		orderItem1.setOrderId(1);
		orderItem1.setProduct(product1);
		orderItem1.setQuantity(5);
		orderItem2 = new OrderItem();
		orderItem2.setOrderId(1);
		orderItem2.setProduct(product2);
		orderItem2.setQuantity(10);
		orderItem2.setOrderItemId(2);
		items = new ArrayList<>();
		items.add(orderItem1);
		items.add(orderItem2);
		order.setOrderItems(items);
		order.setCreationDate(new Date(System.currentTimeMillis()));
		order.setTotalPrice(2750);
		order.setUser(user);
		order.setUserId(1);
		orders = new ArrayList<>();
		orders.add(order);
		optionalUser = Optional.of(user);
	}

	@Test
	void testViewOrderLongLong() throws UserNotFoundException, ResourceNotFoundException, OrderIdNotFoundException {
		try {
			when(orderService.viewOrder(1L, 1)).thenReturn(orders);
		} catch (OrderIdNotFoundException e) {
			assertEquals("Invalid order id", e.getMessage());
		} catch (UserNotFoundException e) {
			assertEquals("Invalid user id", e.getMessage());
		} catch (ResourceNotFoundException e) {
			assertEquals("No order with orderId 0 found associated to this user", e.getMessage());
		}
		assertEquals(orders, orderController.viewOrder(1L, 1));
	}

	@Test()
	void testViewOrderLong() throws OrderIdNotFoundException {
		try {
			when(orderService.viewOrder(1)).thenReturn(orders);
		} catch (OrderIdNotFoundException e) {
			assertEquals("Invalid order id", e.getMessage());
		}
		assertEquals(orders, orderController.viewOrder(1));
	}
}