package com.onlinegrocerydeliverysystem.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.onlinegrocerydeliverysystem.exceptions.InvalidLoginCredentialsException;
import com.onlinegrocerydeliverysystem.exceptions.PasswordNotValidException;
import com.onlinegrocerydeliverysystem.exceptions.UserAlreadyRegisteredException;
import com.onlinegrocerydeliverysystem.exceptions.UserNotFoundException;
import com.onlinegrocerydeliverysystem.exceptions.UserNotLoggedInException;
import com.onlinegrocerydeliverysystem.models.User;
import com.onlinegrocerydeliverysystem.models.UserLogin;

/**
 *  This is the User Service interface
 *  @version 1.0
 */
@Service
public interface UserService {

	/**
	 * This method is to add the User to the system 
	 * @throws UserAlreadyRegisteredException
	 * @param User object
	 * @return User Object
	 */
	public User addUser(User user) throws UserAlreadyRegisteredException, PasswordNotValidException;
	
	/**
	 * This method is to delete the User details from database 
	 * @param User Email Id
	 * @throws UserNotFoundException
	 * @throws UserNotLoggedInException
	 * @return String message
	 */
	public ResponseEntity<String> deleteUser(String emailId) throws UserNotFoundException,UserNotLoggedInException;
	
	/**
	 * This method is to update the User details from database & it returns updated User object
	 * @param User object
	 * @param User email Id
	 * @throws UserNotFoundException
	 * @throws UserNotLoggedInException
	 * @return Updated User object
	 */
	public User updateUser(User user, String emailId)throws UserNotFoundException, UserNotLoggedInException;
	
	/**
	 * This method is to login the User in the system
	 * It throws UserNotFoundException & InvalidLoginCredentialsException
	 * @param User email Id 
	 * @param User password 
	 * @throws UserNotFoundException
	 * @throws UserNotLoggedInException
	 * @return Http Response Entity
	 */

	public ResponseEntity<Object> loginUser(UserLogin userLogin) throws UserNotFoundException, InvalidLoginCredentialsException;
	
	/**
	 * This method is to logout the User from the system
	 * @throws UserNotLoggedInException
	 * @return Http Response 
	 */
	public ResponseEntity<Object> logoutUser() throws UserNotLoggedInException;
	
}
