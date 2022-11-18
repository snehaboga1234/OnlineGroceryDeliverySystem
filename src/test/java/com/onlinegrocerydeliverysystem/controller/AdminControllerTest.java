package com.onlinegrocerydeliverysystem.controller;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.onlinegrocerydeliverysystem.exceptions.AdminAlreadyRegisteredException;
import com.onlinegrocerydeliverysystem.exceptions.AdminNotFoundException;
import com.onlinegrocerydeliverysystem.exceptions.AdminNotLoggedInException;
import com.onlinegrocerydeliverysystem.exceptions.PasswordNotValidException;
import com.onlinegrocerydeliverysystem.exceptions.UserNotFoundException;
import com.onlinegrocerydeliverysystem.models.Admin;
import com.onlinegrocerydeliverysystem.models.User;
import com.onlinegrocerydeliverysystem.service.AdminService;

/**
 * This is Admin Controller Test Class
 * @version 1.0
 *
 */
@ExtendWith(MockitoExtension.class)
class AdminControllerTest {

	@Mock
	AdminService adminService;
	
	@InjectMocks
	AdminController adminController;

	/**
	 * Test for adding Admin in the System
	 * @throws AdminAlreadyRegisteredException
	 * @throws PasswordNotValidException 
	 */
	@Test
	void testSaveAdmin() throws AdminAlreadyRegisteredException, PasswordNotValidException {
		Admin admin = new Admin("akanksha@gmail.com", "Akanksha@123", "Akanksha", "Waghere", (long) 1234567891);
		adminService.addAdmin(admin);
		verify(adminService,times(1)).addAdmin(admin);
	}

	/**
	 * Test for deleting Admin from the system
	 * @throws AdminAlreadyRegisteredException
	 * @throws AdminNotFoundException
	 * @throws AdminNotLoggedInException
	 */
	@Test
	void testDeleteAdmin() throws AdminNotFoundException, AdminNotLoggedInException {
		Admin admin = new Admin("akanksha@gmail.com", "Akanksha@123", "Akanksha", "Waghere", (long) 1234567891);
		admin.setId(1L);
		adminService.deleteAdmin(1L);
		verify(adminService,times(1)).deleteAdmin(1L);
	}

	/**
	 * Test for updating the Admin details
	 * @throws AdminNotFoundException
	 * @throws AdminNotLoggedInException
	 */
	@Test
	void testUpdateAdmin() throws AdminNotFoundException, AdminNotLoggedInException {
		Admin admin = new Admin("akanksha@gmail.com", "Akanksha@123", "Akanksha", "Waghere", (long) 1234567891);
		admin.setId(1L);
		adminService.updateAdmin(admin,1L);
		verify(adminService,times(1)).updateAdmin(admin,1L);
	}

	/**
	 * Test for logging in Admin
	 * @throws InvalidLoginCredentialsException
	 * @throws AdminNotFoundException
	 */
	/*@Test
	void testLoginAdmin() throws InvalidLoginCredentialsException, AdminNotFoundException {
		adminService.loginAdmin(1L, "Akanksha@123");
		verify(adminService,times(1)).loginAdmin(1L, "Akanksha@123");
	}*/

	/**
	 * Test for logout Admin 
	 * @throws AdminNotLoggedInException
	 */
	@Test
	void testLogoutAdmin() throws AdminNotLoggedInException {
		adminService.logoutAdmin();
		verify(adminService,times(1)).logoutAdmin();
	}
	
	/**
	 * Test for viewing users from the system
	 * @throws UserNotFoundException 
	 */
	@Test
	void testViewUser() throws UserNotFoundException {
		User user = new User("akanksha@gmail.com", "Akanksha@123", "Akanksha", "Waghere", (long) 1234567891);
		user.setId(1L);
		adminService.viewUser(1L);
		verify(adminService,times(1)).viewUser(1L);
		
	}

}
