package com.onlinegrocerydeliverysystem.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.onlinegrocerydeliverysystem.exceptions.AdminAlreadyRegisteredException;
import com.onlinegrocerydeliverysystem.exceptions.AdminNotFoundException;
import com.onlinegrocerydeliverysystem.exceptions.AdminNotLoggedInException;
import com.onlinegrocerydeliverysystem.exceptions.InvalidLoginCredentialsException;
import com.onlinegrocerydeliverysystem.exceptions.PasswordNotValidException;
import com.onlinegrocerydeliverysystem.exceptions.UserNotFoundException;
import com.onlinegrocerydeliverysystem.models.Admin;
import com.onlinegrocerydeliverysystem.models.AdminLogin;
import com.onlinegrocerydeliverysystem.models.User;

/**
 *  This is the Admin Service interface
 *  @version 1.0
 */
@Service
public interface AdminService {
	
	/**
	 * This method is to add the Admin to the system 
	 * @param Admin object
	 * @return Admin Object
	 */
	public ResponseEntity<String> addAdmin(Admin admin) throws AdminAlreadyRegisteredException, PasswordNotValidException;
	
	/**
	 * This method is to delete the Admin details from system
	 * @param Admin Id
	 * @return String message
	 */
	public ResponseEntity<String> deleteAdmin(long id) throws AdminNotFoundException, AdminNotLoggedInException;
	
	/**
	 * This method is to update the Admin details from system 
	 * @param Admin object
	 * @param Admin Id 
	 * @return Updated Admin object
	 */
	public ResponseEntity<String> updateAdmin(Admin admin,long id) throws AdminNotFoundException, AdminNotLoggedInException;
	
	/**
	 * This method is to login the Admin in the system
	 * @throws UserNotFoundException 
	 * @throws InvalidLoginCredentialsException
	 * @param Admin Id
	 * @param Admin Password
	 * @return Http Response
	 */
	public ResponseEntity<Object> loginAdmin(AdminLogin adminLogin) throws InvalidLoginCredentialsException, AdminNotFoundException;
	
	/**
	 * This method is used to logout the admin from the system
	 * It throws UserNotLoggedInException
	 * @throws AdminNotLoggedInException 
	 * @return Http Response
	 */
	public ResponseEntity<Object> logoutAdmin() throws AdminNotLoggedInException;

	/**
	 * This method is to find a user with his userId
	 * @param Admin Id
	 * @return Admin object
	 * @throws UserNotFoundException 
	 */
	public User viewUser(long userId) throws UserNotFoundException;
	
	public List<User> allUsers()throws UserNotFoundException;


}
