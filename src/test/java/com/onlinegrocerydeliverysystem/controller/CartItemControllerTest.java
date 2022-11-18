package com.onlinegrocerydeliverysystem.controller;

import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import com.onlinegrocerydeliverysystem.dto.CartItemDto;
import com.onlinegrocerydeliverysystem.exceptions.CartItemNotFoundException;
import com.onlinegrocerydeliverysystem.exceptions.NotEnoughStockException;
import com.onlinegrocerydeliverysystem.exceptions.ProductNotFoundException;
import com.onlinegrocerydeliverysystem.exceptions.UserNotFoundException;
import com.onlinegrocerydeliverysystem.models.CartItem;
import com.onlinegrocerydeliverysystem.models.Product;
import com.onlinegrocerydeliverysystem.service.CartItemService;

/**
 * Test class for CartItemController class.
 * 
 * @see CartItemControllerTest
 * @version 1.0
 */
@ExtendWith(MockitoExtension.class)
class CartItemControllerTest {

	/**
	 * CartItemService mock object.
	 */
	@Mock
	CartItemService cartItemService;

	/**
	 * CartItemController
	 */
	@InjectMocks
	CartItemController cartItemController;

	/**
	 * Test case for addToCart method.
	 * 
	 * @throws UserNotFoundException
	 * @throws ProductNotFoundException
	 * @throws NotEnoughStockException
	 */
	@Test
	void testAddToCart() throws UserNotFoundException, ProductNotFoundException, NotEnoughStockException {
		CartItem cartItem = new CartItem(1L, 2L, 30);
		Mockito.when(cartItemService.addToCart(cartItem)).thenReturn("CartItem [userId=1, productId=2, quantity=30]");
		assertEquals("CartItem [userId=1, productId=2, quantity=30]", cartItemController.addToCart(cartItem).getBody());
	}

	/**
	 * Test case for updateCartItem method.
	 * 
	 * @throws CartItemNotFoundException
	 * @throws NotEnoughStockException
	 * @throws ProductNotFoundException
	 */
	@Test
	void testUpdateCartItem() throws CartItemNotFoundException, NotEnoughStockException, ProductNotFoundException {
		CartItem cartItem = new CartItem(1L, 2L, 100);
		Mockito.when(cartItemService.updateCartItem(1L, cartItem))
				.thenReturn("Cart Item successfully updated to CartItem[userId=1, productId=2, quantity=100]");
		assertEquals("Cart Item successfully updated to CartItem[userId=1, productId=2, quantity=100]",
				cartItemController.updateCartItem(1L, cartItem).getBody());
	}

	/**
	 * Test case for deleteCartItem method.
	 * 
	 * @throws CartItemNotFoundException
	 */
	@Test
	void testDeleteCartItem() throws CartItemNotFoundException {
		Mockito.when(cartItemService.deleteCartItem(1L))
				.thenReturn("CartItem [userId=1, productId=2, quantity=100] successfully deleted from user's cart.");
		assertEquals("CartItem [userId=1, productId=2, quantity=100] successfully deleted from user's cart.",
				cartItemController.deleteCartItem(1L).getBody());
	}
	
}
