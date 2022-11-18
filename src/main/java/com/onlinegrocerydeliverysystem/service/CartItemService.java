package com.onlinegrocerydeliverysystem.service;

import java.util.List;

import com.onlinegrocerydeliverysystem.exceptions.CartEmptyException;
import com.onlinegrocerydeliverysystem.exceptions.CartItemNotFoundException;
import com.onlinegrocerydeliverysystem.exceptions.NotEnoughStockException;
import com.onlinegrocerydeliverysystem.exceptions.ProductNotFoundException;
import com.onlinegrocerydeliverysystem.exceptions.UserNotFoundException;
import com.onlinegrocerydeliverysystem.models.CartItem;

/**
 * A service interface to define CRUD operations on the CartItem entity.
 * 
 * @see CartItemService
 * @version 1.0
 */
public interface CartItemService {

	/**
	 * Service method to add a cart item to a user's cart.
	 * 
	 * @param cartItem
	 * @return
	 * @throws UserNotFoundException
	 * @throws ProductNotFoundException
	 * @throws NotEnoughStockException
	 */
	public String addToCart(CartItem cartItem)
			throws UserNotFoundException, ProductNotFoundException, NotEnoughStockException;

	/**
	 * Service method to retrieve a list of cart items in the cart of a user.
	 * 
	 * @param userId
	 * @return list of cart items associated with userId.
	 */
	public List<CartItem> getCart(long userId);

	/**
	 * Service method to update a cart item.
	 * 
	 * @param cartItemId
	 * @param newCartItem
	 * @return
	 * @throws CartItemNotFoundException
	 * @throws NotEnoughStockException
	 * @throws ProductNotFoundException
	 */
	public String updateCartItem(long cartItemId, CartItem newCartItem)
			throws CartItemNotFoundException, NotEnoughStockException, ProductNotFoundException;

	/**
	 * Service method to delete a cart item.
	 * 
	 * @param cartItemId
	 * @return
	 * @throws CartItemNotFoundException
	 */
	public String deleteCartItem(long cartItemId) throws CartItemNotFoundException;

	public String orderCartItem(long userId) throws CartEmptyException, NotEnoughStockException, UserNotFoundException;
}
