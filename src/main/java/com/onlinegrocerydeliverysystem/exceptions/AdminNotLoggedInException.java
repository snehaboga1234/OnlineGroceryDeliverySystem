package com.onlinegrocerydeliverysystem.exceptions;

/**
 * 
 * @see AdminNotLoggedInException
 * @version 1.0
 *
 */

@SuppressWarnings("serial")
public class AdminNotLoggedInException extends Exception{
	private final String message;

	/**
	 * @param message
	 */
	public AdminNotLoggedInException(String message) {
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
