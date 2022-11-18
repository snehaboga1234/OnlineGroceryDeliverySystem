package com.onlinegrocerydeliverysystem.serviceimpl;

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
import com.onlinegrocerydeliverysystem.repository.OrderItemRepository;
import com.onlinegrocerydeliverysystem.repository.OrderRepository;
import com.onlinegrocerydeliverysystem.repository.ProductRepository;
import com.onlinegrocerydeliverysystem.repository.UserRepository;

@ExtendWith(MockitoExtension.class)
class OrderServiceImplTest {

	@Mock
	OrderRepository orderRepository;
	@Mock
	UserRepository userRepository;
	@Mock
	ProductRepository productRepository;
	@Mock
	OrderItemRepository orderItemRepository;
	@InjectMocks
	private OrderServiceImpl orderService;

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
		when(orderRepository.findById(1)).thenReturn(orders);
		when(orderRepository.findByIdAndUserId(1, 1L)).thenReturn(orders);
		when(userRepository.existsById(1L)).thenReturn(true);
		assertEquals(orders, orderService.viewOrder(1, 1L));
	}

	@Test()
	void testViewOrderLong() throws OrderIdNotFoundException {
		when(orderRepository.findById(1)).thenReturn(orders);
		when(orderRepository.findAllById(1)).thenReturn(orders);
		assertEquals(orders, orderService.viewOrder(1));
	}

	@Test()
	void testViewOrderLongInvalidOrderId() throws OrderIdNotFoundException {
		when(orderRepository.findById(0)).thenReturn(null);
		try {
			orderService.viewOrder(0);
		} catch (OrderIdNotFoundException e) {
			assertEquals("Invalid order id", e.getMessage());
		}
	}

	@Test()
	void testViewOrderLongLongInvalidUserId()
			throws OrderIdNotFoundException, UserNotFoundException, ResourceNotFoundException {
		when(userRepository.existsById(0L)).thenReturn(false);
		try {
			orderService.viewOrder(0, 1);
		} catch (UserNotFoundException e) {
			assertEquals("Invalid user id", e.getMessage());
		}
	}

	@Test
	void testViewOrderLongLongInvalidOrderId()
			throws OrderIdNotFoundException, UserNotFoundException, ResourceNotFoundException {
		when(userRepository.existsById(1L)).thenReturn(true);
		when(orderRepository.findById(0)).thenReturn(null);
		try {
			orderService.viewOrder(1L, 0);
		} catch (OrderIdNotFoundException e) {
			assertEquals("Invalid order id", e.getMessage());
		}
	}

	@Test
	void testViewOrderLongLongInvalidOrderIdAndUserId()
			throws OrderIdNotFoundException, UserNotFoundException, ResourceNotFoundException {
		when(userRepository.existsById(1L)).thenReturn(true);
		when(orderRepository.findByIdAndUserId(0, 1L)).thenReturn(new ArrayList<>());
		try {
			orderService.viewOrder(1L, 0);
		} catch (ResourceNotFoundException e) {
			assertEquals("No order with orderId 0 found associated to this user", e.getMessage());
		}
	}
}
