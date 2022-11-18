package com.onlinegrocerydeliverysystem.exceptions;

/**
 * 
 * @see NotEnoughStockException
 * @version 1.0
 *
 */

@SuppressWarnings("serial")
public class NotEnoughStockException extends Exception {


	public NotEnoughStockException() {
		super();
	}

	public NotEnoughStockException(String message) {
		super(message);
	}

}
