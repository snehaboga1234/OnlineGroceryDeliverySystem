package com.onlinegrocerydeliverysystem.controller;

import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.onlinegrocerydeliverysystem.exceptions.AdminAlreadyRegisteredException;
import com.onlinegrocerydeliverysystem.exceptions.AdminNotFoundException;
import com.onlinegrocerydeliverysystem.exceptions.AdminNotLoggedInException;
import com.onlinegrocerydeliverysystem.exceptions.CartEmptyException;
import com.onlinegrocerydeliverysystem.exceptions.CartItemNotFoundException;
import com.onlinegrocerydeliverysystem.exceptions.InvalidLoginCredentialsException;
import com.onlinegrocerydeliverysystem.exceptions.NotEnoughStockException;
import com.onlinegrocerydeliverysystem.exceptions.OrderIdNotFoundException;
import com.onlinegrocerydeliverysystem.exceptions.PasswordNotValidException;
import com.onlinegrocerydeliverysystem.exceptions.ProductNotFoundException;
import com.onlinegrocerydeliverysystem.exceptions.ResourceNotFoundException;
import com.onlinegrocerydeliverysystem.exceptions.UserAlreadyRegisteredException;
import com.onlinegrocerydeliverysystem.exceptions.UserNotFoundException;
import com.onlinegrocerydeliverysystem.exceptions.UserNotLoggedInException;
import com.onlinegrocerydeliverysystem.exceptions.ValidationFailedException;

/**
 * 
 * Class to handle all exceptions
 * 
 * @see ExceptionController
 * @version 1.0
 *
 */
@CrossOrigin("http://localhost:4200/")
@ControllerAdvice
public class ExceptionController {

	/**
	 * This method is to handle the exceptions arising when user inputs invalid
	 * password
	 * 
	 * @param Exception
	 * @return Http Response
	 */
	@ExceptionHandler(value = PasswordNotValidException.class)
	public ResponseEntity<Object> passwordNotValidException(Exception e) {
		return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
	}

	/**
	 * This method is to handle the exceptions arising when user inputs invalid data
	 * format
	 * 
	 * @param Exception
	 * @return Http Response
	 */
	@ExceptionHandler(value = MethodArgumentNotValidException.class)
	public ResponseEntity<Object> methodArgumentNotValidException(Exception e) {
		return new ResponseEntity<>(((BindException) e).getBindingResult().getFieldErrors().stream()
				.map(DefaultMessageSourceResolvable::getDefaultMessage)
				.collect(java.util.stream.Collectors.joining("\n")), HttpStatus.BAD_REQUEST);

	}

	/**
	 * This method is to handle the exceptions arising when admin is not present in
	 * the database
	 * 
	 * @param Exception
	 * @return Http Response
	 */
	@ExceptionHandler(value = AdminNotFoundException.class)
	public ResponseEntity<Object> adminNotFoundException(Exception e) {
		return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
	}

	/**
	 * This method is to handle the exceptions arising when user is not present in
	 * the database
	 * 
	 * @param Exception
	 * @return Http Response
	 */
	@ExceptionHandler(value = UserNotFoundException.class)
	public ResponseEntity<Object> userNotFoundException(Exception e) {
		return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
	}

	/**
	 * This method is to handle the exceptions arising when order id is invalid
	 * 
	 * @param Exception
	 * @return Http Response
	 */
	@ExceptionHandler(value = OrderIdNotFoundException.class)
	public ResponseEntity<Object> invalidOrderIdException(Exception e) {
		return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
	}

	/**
	 * This method is to handle the exceptions arising when user tries to order
	 * items with empty cart
	 * 
	 * @param Exception
	 * @return Http Response
	 */
	@ExceptionHandler(value = CartEmptyException.class)
	public ResponseEntity<Object> cartEmptyException(Exception e) {
		return new ResponseEntity<>(e.getMessage(), HttpStatus.NO_CONTENT);
	}

	/**
	 * This method is to handle the exceptions arising when product is not found in
	 * the database
	 * 
	 * @param Exception
	 * @return Http Response
	 */
	@ExceptionHandler(value = ProductNotFoundException.class)
	public ResponseEntity<Object> productNotFoundException(Exception e) {
		return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
	}

	/**
	 * This method is to handle the exceptions arising when user or admin provides
	 * wrong credentials for their accout
	 * 
	 * @param Exception
	 * @return Http Response
	 */
	@ExceptionHandler(value = InvalidLoginCredentialsException.class)
	public ResponseEntity<Object> invalidLoginCredentialsException(Exception e) {
		return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
	}

	/**
	 * This method is to handle the exceptions arising when logout is used even when
	 * no user is logged in/ or when user tries to add item into cart before logging
	 * in
	 * 
	 * @param Exception
	 * @return Http Response
	 */
	@ExceptionHandler(value = UserNotLoggedInException.class)
	public ResponseEntity<Object> userNotLoggedInException(Exception e) {
		return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
	}

	/**
	 * This method is to handle the exceptions arising when any detail could not be
	 * verified
	 * 
	 * @param Exception
	 * @return Http Response
	 */
	@ExceptionHandler(value = ValidationFailedException.class)
	public ResponseEntity<Object> validationFailedException(Exception e) {
		return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
	}

	/**
	 * This method is to handle the exceptions arising when user add quantity of
	 * item that is not present in stock
	 * 
	 * @param Exception
	 * @return Http Response
	 */
	@ExceptionHandler(value = NotEnoughStockException.class)
	public ResponseEntity<Object> notEnoughStockException(Exception e) {
		return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
	}

	/**
	 * This method is to handle the exceptions arising when an item in the cart is
	 * not found in the database
	 * 
	 * @param Exception
	 * @return Http Response
	 */
	@ExceptionHandler(value = CartItemNotFoundException.class)
	public ResponseEntity<Object> cartItemNotFoundException(Exception e) {
		return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
	}

	/**
	 * This method is to handle the exceptions arising when user tries to
	 * re-register with same email id
	 * 
	 * @param Exception
	 * @return Http Response
	 */
	@ExceptionHandler(value = UserAlreadyRegisteredException.class)
	public ResponseEntity<Object> userAlreadyRegisteredException(Exception e) {
		return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
	}

	/**
	 * This method is to handle the exceptions arising when new admin is registered
	 * with same id
	 * 
	 * @param Exception
	 * @return Http Response
	 */
	@ExceptionHandler(value = AdminAlreadyRegisteredException.class)
	public ResponseEntity<Object> adminAlreadyRegisteredException(Exception e) {
		return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
	}

	/**
	 * This method is to handle the exceptions arising when logout is used even when
	 * no admin is logged in
	 * 
	 * @param Exception
	 * @return Http Response
	 */
	@ExceptionHandler(value = AdminNotLoggedInException.class)
	public ResponseEntity<Object> adminNotLoggedInException(Exception e) {
		return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
	}

	/**
	 * This method is to handle the exceptions arising when associated resources can
	 * not be found in the database
	 * 
	 * @param Exception
	 * @return Http Response
	 */
	@ExceptionHandler(value = ResourceNotFoundException.class)
	public ResponseEntity<Object> resourceNotFoundException(Exception e) {
		return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
	}
}
