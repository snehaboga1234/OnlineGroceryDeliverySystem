package com.onlinegrocerydeliverysystem.exceptions;

/**
 * 
 * @see ResourceNotFoundException
 * @version 1.0
 *
 */

@SuppressWarnings("serial")
public class ResourceNotFoundException extends Exception{
	
	private final String message;

	/**
	 * @param message
	 */
	public ResourceNotFoundException(String message) {
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
