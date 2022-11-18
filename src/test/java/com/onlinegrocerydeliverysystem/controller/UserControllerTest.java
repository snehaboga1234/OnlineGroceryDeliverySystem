package com.onlinegrocerydeliverysystem.controller;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.onlinegrocerydeliverysystem.exceptions.InvalidLoginCredentialsException;
import com.onlinegrocerydeliverysystem.exceptions.PasswordNotValidException;
import com.onlinegrocerydeliverysystem.exceptions.UserAlreadyRegisteredException;
import com.onlinegrocerydeliverysystem.exceptions.UserNotFoundException;
import com.onlinegrocerydeliverysystem.exceptions.UserNotLoggedInException;
import com.onlinegrocerydeliverysystem.models.User;
import com.onlinegrocerydeliverysystem.service.UserService;

/**
 * This is User Controller Test Class
 * 
 * @version 1.0
 *
 */
@ExtendWith(MockitoExtension.class)
class UserControllerTest {

	@Mock
	UserService userService;

	@InjectMocks
	UserController userController;

	/**
	 * Test for adding User in system
	 * 
	 * @throws UserAlreadyRegisteredException
	 */
	@Test
	void testSaveUser() throws UserAlreadyRegisteredException, PasswordNotValidException {
		User user = Mockito.mock(User.class);
		user = new User("akanksha@gmail.com", "Akanksha@123", "Akanksha", "Waghere", 1234567891L);
		userService.addUser(user);
		verify(userService, times(1)).addUser(user);
	}

	/**
	 * Test for deleting User from the system
	 * 
	 * @throws UserAlreadyRegisteredException
	 * @throws UserNotFoundException
	 * @throws UserNotLoggedInException
	 */
	@Test
	void testDeleteUser() throws UserNotFoundException, UserNotLoggedInException {
		userService.deleteUser("akanksha@gmail.com");
		verify(userService, times(1)).deleteUser("akanksha@gmail.com");

	}

	/**
	 * Test for updating User details
	 * 
	 * @throws UserAlreadyRegisteredException
	 * @throws UserNotFoundException
	 * @throws UserNotLoggedInException
	 */
	@Test
	void testUpdateUser() throws UserNotFoundException, UserNotLoggedInException {
		User user = new User("akanksha@gmail.com", "Akanksha@123", "Akanksha", "Waghere", 1234567891L);
		userService.updateUser(user, "akanksha@gmail.com");
		verify(userService, times(1)).updateUser(user, "akanksha@gmail.com");

	}

	/**
	 * Test for logout User
	 * 
	 * @throws UserAlreadyRegisteredException
	 * @throws UserNotFoundException
	 * @throws InvalidLoginCredentialsException
	 * @throws UserNotLoggedInException
	 */
	@Test
	void testLogoutUser() throws UserNotLoggedInException {
		userService.logoutUser();
		verify(userService, times(1)).logoutUser();

	}

}
