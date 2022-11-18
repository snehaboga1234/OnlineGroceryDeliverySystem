package com.onlinegrocerydeliverysystem.exceptions;

/**
 * 
 * @see AdminNotFoundException
 * @version 1.0
 *
 */

@SuppressWarnings("serial")
public class AdminNotFoundException extends Exception{
	
	private final String message;

	/**
	 * @param message
	 */
	public AdminNotFoundException(String message) {
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
