package com.onlinegrocerydeliverysystem.exceptions;

/**
 * 
 * @see CartEmptyException
 * @version 1.0
 *
 */

@SuppressWarnings("serial")
public class CartEmptyException extends Exception{

	private final String message;

	/**
	 * @param message
	 */
	public CartEmptyException(String message) {
		this.message = message;
	}

	/**
	 * @return the message
	 */
	@Override
	public String getMessage() {
		return message;
	}
	
}
