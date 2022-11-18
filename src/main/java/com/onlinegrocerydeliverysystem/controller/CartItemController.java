package com.onlinegrocerydeliverysystem.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onlinegrocerydeliverysystem.dto.CartItemDto;
import com.onlinegrocerydeliverysystem.exceptions.CartEmptyException;
import com.onlinegrocerydeliverysystem.exceptions.CartItemNotFoundException;
import com.onlinegrocerydeliverysystem.exceptions.NotEnoughStockException;
import com.onlinegrocerydeliverysystem.exceptions.ProductNotFoundException;
import com.onlinegrocerydeliverysystem.exceptions.UserNotFoundException;
import com.onlinegrocerydeliverysystem.models.CartItem;
import com.onlinegrocerydeliverysystem.service.CartItemService;

/**
 * Controller class for handling HTTP requests associated with the CartItem
 * entity.
 *
 * @see CartItemController
 * @version 1.0
 */
@CrossOrigin("http://localhost:4200/")
@RestController
@RequestMapping("/cart")
public class CartItemController {

	/**
	 * CartItemService object.
	 */
	@Autowired
	private CartItemService cartItemService;

	/**
	 * Method to get all the Cart Items associated with a user by their userId
	 * 
	 * @param userId
	 * @return an HTTP response containing a list of cart items associated with a
	 *         user.
	 */
	@GetMapping("/user/{userid}")
	public ResponseEntity<List<CartItemDto>> getUserCart(@PathVariable("userid") long userId) {
		return new ResponseEntity<>(
				cartItemService.getCart(userId).stream().map(CartItemDto::new).collect(Collectors.toList()),
				HttpStatus.OK);
	}

	/**
	 * Method to add a cart item to a user's cart
	 * 
	 * @param cartItem
	 * @return an HTTP response with a message and an HTTP status created if the
	 *         cart item is added successfully.
	 * @throws UserNotFoundException
	 * @throws ProductNotFoundException
	 * @throws NotEnoughStockException
	 */
	@PostMapping("/add-to-cart")
	public ResponseEntity<String> addToCart(@Valid @RequestBody CartItem cartItem)
			throws UserNotFoundException, ProductNotFoundException, NotEnoughStockException {
		return new ResponseEntity<>(cartItemService.addToCart(cartItem), HttpStatus.CREATED);

	}

	/**
	 * Method to update a cart item with a particular cartItemId.
	 * 
	 * @param cartItemId
	 * @param newCartItem
	 * @return an HTTP response with a message and an HTTP status OK if the cart
	 *         item is updated successfully.
	 * @throws CartItemNotFoundException
	 * @throws NotEnoughStockException
	 * @throws ProductNotFoundException
	 */
	@PutMapping("/{cart_item_id}")
	public ResponseEntity<String> updateCartItem(@PathVariable("cart_item_id") long cartItemId,
			@Valid @RequestBody CartItem newCartItem)
			throws CartItemNotFoundException, NotEnoughStockException, ProductNotFoundException {
		return new ResponseEntity<>(cartItemService.updateCartItem(cartItemId, newCartItem), HttpStatus.OK);
	}

	/**
	 * Method to delete a cart item associated with a particular cartItemId.
	 * 
	 * @param cartItemId
	 * @return an HTTP response with a message and an HTTP status OK if the cart
	 *         item is deleted successfully.
	 * @throws CartItemNotFoundException
	 */
	@DeleteMapping("/{cart_item_id}")
	public ResponseEntity<String> deleteCartItem(@PathVariable("cart_item_id") long cartItemId)
			throws CartItemNotFoundException {
		return new ResponseEntity<>(cartItemService.deleteCartItem(cartItemId), HttpStatus.OK);

	}

	@GetMapping("/user/order/{userId}")
	public ResponseEntity<String> orderCartItem(@PathVariable("userId") long userId)
			throws CartEmptyException, NotEnoughStockException, UserNotFoundException {
		return new ResponseEntity<>(cartItemService.orderCartItem(userId), HttpStatus.OK);
	}
}
