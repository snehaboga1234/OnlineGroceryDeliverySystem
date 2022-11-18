package com.onlinegrocerydeliverysystem.exceptions;

public class ProductAlreadyExistException extends Exception {
	private final String message;

	/**
	 * @param message
	 */
	public ProductAlreadyExistException(String message) {
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
