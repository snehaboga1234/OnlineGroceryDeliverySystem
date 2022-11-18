package com.onlinegrocerydeliverysystem.exceptions;

/**
 * 
 * @see ValidationFailedException
 * @version 1.0
 *
 */

@SuppressWarnings("serial")
public class ValidationFailedException extends Exception{
	
	private final String message;

	/**
	 * @param message
	 */
	public ValidationFailedException(String message) {
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
