package com.onlinegrocerydeliverysystem.exceptions;

/**
 * 
 * @see ProductNotFoundException
 * @version 1.0
 *
 */

@SuppressWarnings("serial")
public class ProductNotFoundException extends Exception{
	
	private final String message;

	/**
	 * @param message
	 */
	public ProductNotFoundException(String message) {
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
