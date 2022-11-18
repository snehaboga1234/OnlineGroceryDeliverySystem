package com.onlinegrocerydeliverysystem.exceptions;

/**
 * 
 * @see UserAlreadyRegisteredException
 * @version 1.0
 *
 */

@SuppressWarnings("serial")
public class UserAlreadyRegisteredException extends Exception {
	private final String message;

	/**
	 * @param message
	 */
	public UserAlreadyRegisteredException(String message) {
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
