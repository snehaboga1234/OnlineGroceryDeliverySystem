package com.onlinegrocerydeliverysystem.exceptions;

/**
 * 
 * @see UserNotFoundException
 * @version 1.0
 *
 */

@SuppressWarnings("serial")
public class UserNotFoundException extends Exception{
	
	private final String message;

	/**
	 * @param message
	 */
	public UserNotFoundException(String message) {
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
