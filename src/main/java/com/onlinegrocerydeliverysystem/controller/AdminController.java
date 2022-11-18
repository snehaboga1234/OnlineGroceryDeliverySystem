package com.onlinegrocerydeliverysystem.controller;

import java.util.List;

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

import com.onlinegrocerydeliverysystem.exceptions.AdminAlreadyRegisteredException;
import com.onlinegrocerydeliverysystem.exceptions.AdminNotFoundException;
import com.onlinegrocerydeliverysystem.exceptions.AdminNotLoggedInException;
import com.onlinegrocerydeliverysystem.exceptions.InvalidLoginCredentialsException;
import com.onlinegrocerydeliverysystem.exceptions.PasswordNotValidException;
import com.onlinegrocerydeliverysystem.exceptions.UserNotFoundException;
import com.onlinegrocerydeliverysystem.models.Admin;
import com.onlinegrocerydeliverysystem.models.AdminLogin;
import com.onlinegrocerydeliverysystem.models.User;
import com.onlinegrocerydeliverysystem.service.AdminService;

/**
 * 
 * @see AdminController
 * @version 1.0
 *
 */
@CrossOrigin("http://localhost:4200/")
@RestController
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private AdminService adminService;

	/**
	 * This method is to add the Admin to the system
	 * 
	 * @param Admin object
	 * @throws AdminAlreadyRegisteredException
	 * @return String message
	 * @throws PasswordNotValidException
	 */
	@PostMapping("/add")
	public ResponseEntity<String> saveAdmin(@Valid @RequestBody Admin admin)
			throws AdminAlreadyRegisteredException, PasswordNotValidException {
		adminService.addAdmin(admin);
		return new ResponseEntity<>("Admin added successfully with Admin Id : " + admin.getId(), HttpStatus.CREATED);
	}

	/**
	 * This method is to delete the Admin details from database & it returns string
	 * message
	 * 
	 * @param Admin id
	 * @throws AdminNotFoundException
	 * @throws AdminNotLoggedInException
	 * @return String message
	 */
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteAdmin(@PathVariable("id") long id)
			throws AdminNotFoundException, AdminNotLoggedInException {
		adminService.deleteAdmin(id);
		return new ResponseEntity<>("Admin deleted successfully", HttpStatus.OK);
	}

	/**
	 * This method is to update the Admin details from database & it returns updated
	 * Admin object
	 * 
	 * @param Admin object
	 * @param Admin id
	 * @throws AdminNotFoundException
	 * @throws AdminNotLoggedInException
	 * @return String message
	 */
	@PutMapping("/update/{id}")
	public ResponseEntity<String> updateAdmin(@Valid @RequestBody Admin admin, @PathVariable("id") long id)
			throws AdminNotFoundException, AdminNotLoggedInException {
		adminService.updateAdmin(admin, id);
		return new ResponseEntity<>("Admin details updated successfully", HttpStatus.OK);
	}

	/**
	 * This method is to login the Admin in the system
	 * 
	 * @throws AdminNotFoundException
	 * @throws InvalidLoginCredentialsException
	 * @param Admin id
	 * @param Admin password
	 * @return Http Response
	 */
	@PostMapping("/login")
	public ResponseEntity<Object> loginAdmin(@RequestBody AdminLogin adminLogin)
			throws InvalidLoginCredentialsException, AdminNotFoundException {
		return adminService.loginAdmin(adminLogin);
	}

	/**
	 * This method is to logout the Admin from the system
	 * 
	 * @throws AdminNotLoggedInException
	 * @return Http Response
	 * 
	 */
	@GetMapping("/logout")
	public ResponseEntity<Object> logoutAdmin() throws AdminNotLoggedInException {
		return adminService.logoutAdmin();
	}

	/**
	 * This method is to view the user details
	 * 
	 * @param User id
	 * @return User object
	 * @throws UserNotFoundException
	 */
	@GetMapping("/view/user/{userId}")
	public User viewUser(@PathVariable("userId") long userId) throws UserNotFoundException {
		return adminService.viewUser(userId);
	}

	@GetMapping("/view/users")
	public List<User> allUsers() throws UserNotFoundException {
		return adminService.allUsers();
	}

}
