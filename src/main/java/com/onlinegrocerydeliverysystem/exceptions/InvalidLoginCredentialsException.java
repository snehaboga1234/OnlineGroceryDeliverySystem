package com.onlinegrocerydeliverysystem.exceptions;

/**
 * 
 * @see InvalidLoginCredentialsException
 * @version 1.0
 *
 */

@SuppressWarnings("serial")
public class InvalidLoginCredentialsException extends Exception{

	private final String message;

	/**
	 * @param message
	 */
	public InvalidLoginCredentialsException(String message) {
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
