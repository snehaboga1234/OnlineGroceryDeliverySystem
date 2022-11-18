package com.onlinegrocerydeliverysystem.serviceimpl;

import java.nio.charset.StandardCharsets;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.google.common.hash.Hashing;
import com.onlinegrocerydeliverysystem.dto.UserDto;
import com.onlinegrocerydeliverysystem.exceptions.InvalidLoginCredentialsException;
import com.onlinegrocerydeliverysystem.exceptions.PasswordNotValidException;
import com.onlinegrocerydeliverysystem.exceptions.UserAlreadyRegisteredException;
import com.onlinegrocerydeliverysystem.exceptions.UserNotFoundException;
import com.onlinegrocerydeliverysystem.exceptions.UserNotLoggedInException;
import com.onlinegrocerydeliverysystem.models.User;
import com.onlinegrocerydeliverysystem.models.UserLogin;
import com.onlinegrocerydeliverysystem.repository.UserRepository;
import com.onlinegrocerydeliverysystem.service.UserService;
import com.onlinegrocerydeliverysystem.validation.PasswordValidation;

/**
 * This is the User Service Implementation class
 */
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	User currentUser = null;

	/**
	 * This method is to add the User to the database & it returns User object
	 * 
	 * @param User object
	 * @throws UserAlreadyRegisteredException
	 * @throws PasswordNotValidException
	 * @return User Object
	 */
	@Override
	public User addUser(User user) throws UserAlreadyRegisteredException, PasswordNotValidException {
		if (userRepository.existsByEmailId(user.getEmailId())) {
			System.out.println("User is already registered with email id : " + user.getEmailId());
			throw new UserAlreadyRegisteredException("User already registered with email id :" + user.getEmailId());
		}

		if (PasswordValidation.passwordValid(user.getPassword()))
			user.setPassword(Hashing.sha256().hashString(user.getPassword(), StandardCharsets.UTF_8).toString());
		else {
			System.out.println(
					"Password should have atleast 8 characters, atleast 1 uppercase, atleast 1 lowercase, atleast 1 number & atleast 1 special character.");
			throw new PasswordNotValidException(
					"Password should have atleast 8 characters, atleast 1 uppercase, atleast 1 lowercase, atleast 1 number & atleast 1 special character.");
		}

		userRepository.save(user);
		System.out.println("User is added successfully");
		return user;
	}

	/**
	 * This method is to delete the user details from database & it returns string
	 * message
	 * 
	 * @param User id
	 * @throws UserNotFoundException
	 * @throws UserNotLoggedInException
	 * @return String message
	 */
	@Override
	public ResponseEntity<String> deleteUser(String emailId) throws UserNotFoundException, UserNotLoggedInException {
		if (userRepository.existsByEmailId(emailId)) {
			if (currentUser != null) // check if user logged in
			{
				User user = userRepository.findByEmailId(emailId);
				userRepository.delete(user);
				currentUser = null;
				System.out.println("User has been deleted successfully");
				return new ResponseEntity<>("User deleted successfully", HttpStatus.OK);
			} else {
				System.out.println("User has not logged in");
				throw new UserNotLoggedInException("User has not logged in");
			}
		}
		System.out.println("User not found with the email id : " + emailId);
		throw new UserNotFoundException("User not found with email id :" + emailId);
	}

	/**
	 * This method is to update the user details from database & it returns updated
	 * user object
	 * 
	 * @param User  object
	 * @param Email id of User
	 * @throws UserNotFoundException
	 * @throws UserNotLoggedInException
	 * @return Updated User object
	 */
	@Override
	public User updateUser(User user, String emailId) throws UserNotFoundException, UserNotLoggedInException {
		if (userRepository.existsByEmailId(emailId)) {
			if (currentUser != null) {
				User existingUser = userRepository.findByEmailId(emailId);
				existingUser.setEmailId(user.getEmailId());
				String encryptedPassword = Hashing.sha256().hashString(user.getPassword(), StandardCharsets.UTF_8)
						.toString();
				existingUser.setPassword(encryptedPassword);
				existingUser.setFirstName(user.getFirstName());
				existingUser.setLastName(user.getLastName());
				existingUser.setPhoneNumber(user.getPhoneNumber());
				userRepository.save(existingUser);
				System.out.println("User has been updated successfully");
				return existingUser;
			} else {
				System.out.println("User has not logged in");
				throw new UserNotLoggedInException("User not logged in");
			}
		}
		System.out.println("User not found with email id : " + emailId);
		throw new UserNotFoundException("User not found with email id : " + emailId);

	}

	/**
	 * This method is to login the user in the system It throws
	 * UserNotFoundException & InvalidLoginCredentialsException
	 * 
	 * @param emailId  of user
	 * @param password of user
	 * @throws UserNotFoundException
	 * @throws InvalidLoginCredentialsException
	 * @return Http Response & string message
	 */
	@Override
	public ResponseEntity<Object> loginUser(UserLogin userLogin)
			throws UserNotFoundException, InvalidLoginCredentialsException {
		String encryptedPassword = Hashing.sha256().hashString(userLogin.getPassword(), StandardCharsets.UTF_8)
				.toString();
		if (userRepository.findByEmailId(userLogin.getEmailId()) == null) {
			System.out.println("User not found with email Id : " + userLogin.getEmailId());
			throw new UserNotFoundException("User not found with emailid: " + userLogin.getEmailId());
		} else if (userRepository.findByEmailIdAndPassword(userLogin.getEmailId(), encryptedPassword).isEmpty()) {
			System.out.println("User has given invalid login credentials ");
			throw new InvalidLoginCredentialsException("Invalid login credentials");
		} else if (currentUser == null) {
			currentUser = userRepository.findByEmailIdAndPassword(userLogin.getEmailId(), encryptedPassword).get(0);
			System.out.println("Login successful");
			return new ResponseEntity<>(new UserDto(currentUser), HttpStatus.OK);
		}
		System.out.println("Login has failed as user is already logged in.");
		return new ResponseEntity<>("Login failed, user already logged in.", HttpStatus.BAD_REQUEST);
	}

	/**
	 * This method is to logout the user from the system It throws
	 * UserNotLoggedInException
	 * 
	 * @returns Http Response Entity
	 */
	@Override
	public ResponseEntity<Object> logoutUser() throws UserNotLoggedInException {
		if (currentUser != null) {
			currentUser = null;
			System.out.println("User has logged out successfully");
			return new ResponseEntity<>("User logged out successfully", HttpStatus.OK);
		}
		System.out.println("No user has logged in");
		throw new UserNotLoggedInException("No user logged in");
	}

}
