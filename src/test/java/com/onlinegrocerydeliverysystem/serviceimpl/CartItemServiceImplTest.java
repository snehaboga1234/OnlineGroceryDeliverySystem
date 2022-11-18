package com.onlinegrocerydeliverysystem.serviceimpl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.onlinegrocerydeliverysystem.exceptions.CartItemNotFoundException;
import com.onlinegrocerydeliverysystem.exceptions.NotEnoughStockException;
import com.onlinegrocerydeliverysystem.exceptions.ProductNotFoundException;
import com.onlinegrocerydeliverysystem.exceptions.UserNotFoundException;
import com.onlinegrocerydeliverysystem.models.CartItem;
import com.onlinegrocerydeliverysystem.models.Product;
import com.onlinegrocerydeliverysystem.repository.CartItemRepository;
import com.onlinegrocerydeliverysystem.repository.OrderItemRepository;
import com.onlinegrocerydeliverysystem.repository.OrderRepository;
import com.onlinegrocerydeliverysystem.repository.ProductRepository;
import com.onlinegrocerydeliverysystem.repository.UserRepository;

/**
 * Test Class for CartItemServiceImpl class.
 * 
 * @see CartItemServiceImplTest
 * @version 1.0
 */
@ExtendWith(MockitoExtension.class)
class CartItemServiceImplTest {

	/**
	 * CartItemRepository mock object.
	 */
	@Mock
	CartItemRepository cartItemRepository;

	/**
	 * UserRepository mock object.
	 */
	@Mock
	UserRepository userRepository;

	/**
	 * ProductRepository mock object;
	 */
	@Mock
	ProductRepository productRepository;

	/**
	 * OrderRespository mock object;
	 */
	@Mock
	OrderRepository orderRepository;

	/**
	 * OrderItemRespository mock object;
	 */
	@Mock
	OrderItemRepository orderItemRepository;

	/**
	 * CartItemServiceImpl
	 */
	@InjectMocks
	CartItemServiceImpl cartItemService;

	/**
	 * Positive test case for addToCart method.
	 * 
	 * @throws UserNotFoundException
	 * @throws ProductNotFoundException
	 * @throws NotEnoughStockException
	 */
	@Test
	void testAddToCart() throws UserNotFoundException, ProductNotFoundException, NotEnoughStockException {
		Mockito.when(userRepository.existsById(1L)).thenReturn(true);
		Mockito.when(productRepository.existsById(1L)).thenReturn(true);
		Mockito.when(cartItemRepository.findAllByUserIdAndProductId(1L, 1L)).thenReturn(new ArrayList<>());
		Mockito.when(productRepository.findById(1L)).thenReturn(Optional.of(new Product("Apple", 20, 100, "Fruits")));
		assertEquals("CartItem [userId=1, productId=1, quantity=30] successfully added to user's cart.",
				cartItemService.addToCart(new CartItem(1L, 1L, 30)));
	}

	/**
	 * Negative test case for addToCart method.
	 */
	@Test
	void testAddToCartNegative() {
		Exception exception = assertThrows(UserNotFoundException.class, () -> {
			cartItemService.addToCart(new CartItem(1L, 2L, 30));
		});
		assertEquals("User associated with this cart item does not exist.", exception.getMessage());
	}

	/**
	 * Positive test case for getCart method.
	 */
	@Test
	void testGetCart() {
		List<CartItem> cartItems = Arrays.asList(new CartItem(1L, 1L, 30), new CartItem(1L, 3L, 50));
		Mockito.when(cartItemRepository.findAllByUserId(1L)).thenReturn(cartItems);
		assertEquals(cartItems, cartItemService.getCart(1L));
	}

	/**
	 * Negative test case for getCart method.
	 */
	@Test
	void testGetCartNegative() {
		Mockito.when(cartItemRepository.findAllByUserId(1L)).thenReturn(new ArrayList<CartItem>());
		assertEquals(true, cartItemService.getCart(1L).isEmpty());
	}

	/**
	 * Positive test case for updateCartItem method.
	 * 
	 * @throws CartItemNotFoundException
	 * @throws NotEnoughStockException
	 * @throws ProductNotFoundException
	 */
	@Test
	void testUpdateCartItem() throws CartItemNotFoundException, NotEnoughStockException, ProductNotFoundException {
		CartItem cartItem = new CartItem(3L, 1L, 50);
		cartItem.setId(1);
		Mockito.when(cartItemRepository.findById(1L)).thenReturn(Optional.of(cartItem));
		Mockito.when(productRepository.findById(1L)).thenReturn(Optional.of(new Product("Apple", 30, 200, "Fruits")));
		assertEquals("Cart Item successfully updated to CartItem [userId=3, productId=1, quantity=100]",
				cartItemService.updateCartItem(1L, new CartItem(3L, 1L, 100)));
	}

	/**
	 * Negative test case for updateCartItem method.
	 */
	@Test
	void testUpdateCartItemNegative() {
		Exception exception = assertThrows(CartItemNotFoundException.class, () -> {
			cartItemService.updateCartItem(1L, new CartItem(1L, 2L, 50));
		});
		assertEquals("Cart item with the given id does not exist.", exception.getMessage());
	}

	/**
	 * Positive test case for deleteCartItem method.
	 * 
	 * @throws CartItemNotFoundException
	 */
	@Test
	void testDeleteCartItem() throws CartItemNotFoundException {
		CartItem cartItem = new CartItem(10L, 3L, 10);
		cartItem.setId(20L);
		Mockito.when(cartItemRepository.findById(20L)).thenReturn(Optional.of(cartItem));
		assertEquals("CartItem [userId=10, productId=3, quantity=10] successfully deleted from user's cart.",
				cartItemService.deleteCartItem(20L));
	}

	/**
	 * Negative test case for deleteCartItem method.
	 */
	@Test
	void testDeleteCartItemNegative() {
		Exception exception = assertThrows(CartItemNotFoundException.class, () -> {
			cartItemService.deleteCartItem(1L);
		});
		assertEquals("Cart item with the given id does not exist.", exception.getMessage());
	}

}
