package com.onlinegrocerydeliverysystem.exceptions;

/**
 * @see PasswordNotValidException
 * @version 1.0
 *
 */
@SuppressWarnings("serial")
public class PasswordNotValidException extends Exception {
	private final String message;

	/**
	 * @param message
	 */
	public PasswordNotValidException(String message) {
		this.message=message;
	}

	/**
	 * @return the message
	 */
	@Override
	public String getMessage() {
		return message;
	}
}
