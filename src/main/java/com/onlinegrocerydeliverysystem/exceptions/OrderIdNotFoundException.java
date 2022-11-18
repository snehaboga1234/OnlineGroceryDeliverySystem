package com.onlinegrocerydeliverysystem.exceptions;

/**
 * 
 * @see OrderIdNotFoundException
 * @version 1.0
 *
 */

@SuppressWarnings("serial")
public class OrderIdNotFoundException extends Exception{

	private final String message;

	/**
	 * @param message
	 */
	public OrderIdNotFoundException(String message) {
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
