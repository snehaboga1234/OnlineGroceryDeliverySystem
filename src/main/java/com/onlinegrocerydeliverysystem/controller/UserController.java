package com.onlinegrocerydeliverysystem.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onlinegrocerydeliverysystem.dto.UserDto;
import com.onlinegrocerydeliverysystem.exceptions.InvalidLoginCredentialsException;
import com.onlinegrocerydeliverysystem.exceptions.PasswordNotValidException;
import com.onlinegrocerydeliverysystem.exceptions.UserAlreadyRegisteredException;
import com.onlinegrocerydeliverysystem.exceptions.UserNotFoundException;
import com.onlinegrocerydeliverysystem.exceptions.UserNotLoggedInException;
import com.onlinegrocerydeliverysystem.models.User;
import com.onlinegrocerydeliverysystem.models.UserLogin;
import com.onlinegrocerydeliverysystem.service.UserService;

/**
 * @see UserController
 * @version 1.0
 *
 */
@CrossOrigin("http://localhost:4200/")
@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	/**
	 * This method is to add the User to the database & it returns User object It
	 * throws ValidationFailedException
	 * 
	 * @param User object
	 * @throws UserAlreadyRegisteredException
	 * @return User Object
	 */
	@PostMapping("/add")
	public ResponseEntity<UserDto> saveUser(@Valid @RequestBody User user)
			throws UserAlreadyRegisteredException, PasswordNotValidException {
		return new ResponseEntity<>(new UserDto(userService.addUser(user)), HttpStatus.CREATED);
	}

	/**
	 * This method is to delete the User details from database & it returns string
	 * message
	 * 
	 * @param User email Id
	 * @throws UserNotFoundException
	 * @throws UserNotLoggedInException
	 * @return String message
	 */
	@DeleteMapping("/delete/{emailId}")
	public ResponseEntity<String> deleteUser(@Valid @PathVariable("emailId") String emailId)
			throws UserNotFoundException, UserNotLoggedInException {
		userService.deleteUser(emailId);
		return new ResponseEntity<>("User deleted successfully", HttpStatus.OK);
	}

	/**
	 * This method is to update the user details from database & it returns updated
	 * User object
	 * 
	 * @param User object
	 * @param User email id
	 * @throws UserNotLoggedInException
	 * @throws UserNotFoundException
	 * @return User object
	 */
	@PutMapping("/update/{emailId}")
	public ResponseEntity<UserDto> updateUser(@Valid @RequestBody User user,
			@Valid @PathVariable("emailId") String emailId) throws UserNotFoundException, UserNotLoggedInException {
		return new ResponseEntity<>(new UserDto(userService.updateUser(user, emailId)), HttpStatus.OK);
	}

	/**
	 * This method is to login the User in the system It throws
	 * UserNotFoundException & InvalidLoginCredentialsException
	 * 
	 * @param User email id
	 * @param User password
	 * @return Http Response
	 */
	@PostMapping("/login")
	public ResponseEntity<Object> loginUser(@RequestBody UserLogin userLogin)
			throws UserNotFoundException, InvalidLoginCredentialsException {
		return userService.loginUser(userLogin);
	}

	/**
	 * This method is to logout the user from the system It throws
	 * UserNotLoggedInException
	 * 
	 * @return Http Response
	 */
	@GetMapping("/logout")
	public ResponseEntity<Object> logoutUser() throws UserNotLoggedInException {
		return userService.logoutUser();
	}

}