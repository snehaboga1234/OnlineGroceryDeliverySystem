package com.onlinegrocerydeliverysystem.exceptions;


/**
 * 
 * @see AdminAlreadyRegisteredException
 * @version 1.0
 *
 */
@SuppressWarnings("serial")
public class AdminAlreadyRegisteredException extends Exception {
	private final String message;

	/**
	 * @param message
	 */
	public AdminAlreadyRegisteredException(String message) {
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
