package com.onlinegrocerydeliverysystem.exceptions;

/**
 * 
 * @see UserNotLoggedInException
 * @version 1.0
 *
 */

@SuppressWarnings("serial")
public class UserNotLoggedInException extends Exception{
	
	private final String message;

	/**
	 * @param message
	 */
	public UserNotLoggedInException(String message) {
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
