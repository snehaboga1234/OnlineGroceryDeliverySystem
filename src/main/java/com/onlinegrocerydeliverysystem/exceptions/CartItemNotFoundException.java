package com.onlinegrocerydeliverysystem.exceptions;

/**
 * 
 * @see CartItemNotFoundException
 * @version 1.0
 *
 */

@SuppressWarnings("serial")
public class CartItemNotFoundException extends Exception {

	public CartItemNotFoundException() {
		super();
	}

	public CartItemNotFoundException(String message) {
		super(message);
	}
}
