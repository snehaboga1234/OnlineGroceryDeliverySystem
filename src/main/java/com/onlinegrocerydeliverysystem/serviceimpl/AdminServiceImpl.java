package com.onlinegrocerydeliverysystem.serviceimpl;

import java.nio.charset.StandardCharsets;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.google.common.hash.Hashing;
import com.onlinegrocerydeliverysystem.exceptions.AdminAlreadyRegisteredException;
import com.onlinegrocerydeliverysystem.exceptions.AdminNotFoundException;
import com.onlinegrocerydeliverysystem.exceptions.AdminNotLoggedInException;
import com.onlinegrocerydeliverysystem.exceptions.InvalidLoginCredentialsException;
import com.onlinegrocerydeliverysystem.exceptions.PasswordNotValidException;
import com.onlinegrocerydeliverysystem.exceptions.UserNotFoundException;
import com.onlinegrocerydeliverysystem.models.Admin;
import com.onlinegrocerydeliverysystem.models.AdminLogin;
import com.onlinegrocerydeliverysystem.models.User;
import com.onlinegrocerydeliverysystem.repository.AdminRepository;
import com.onlinegrocerydeliverysystem.repository.UserRepository;
import com.onlinegrocerydeliverysystem.service.AdminService;
import com.onlinegrocerydeliverysystem.validation.PasswordValidation;


/**
 *  @see AdminServiceImpl
 *  @version 1.0
 */
@Service
public class AdminServiceImpl implements AdminService{
	
	@Autowired
	private AdminRepository adminRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	Admin currentAdmin = null;
	
	/**
	 * This method is to add the Admin to the system 
	 * @param Admin object
	 * @throws AdminAlreadyRegisteredException
	 * @return  String message
	 * @throws PasswordNotValidException 
	 */
	@Override
	public ResponseEntity<String> addAdmin(Admin admin) throws AdminAlreadyRegisteredException, PasswordNotValidException{
		if(adminRepository.existsByEmailId(admin.getEmailId())) {
			System.out.println("Admin with emailid "+admin.getEmailId()+" is already registered");
			throw new AdminAlreadyRegisteredException("Admin is already registered");
		}
		if(PasswordValidation.passwordValid(admin.getPassword()))
			admin.setPassword(Hashing.sha256().hashString(admin.getPassword(),StandardCharsets.UTF_8).toString());
		else {
			System.out.println("Password should have at least 8 characters, atleast 1 uppercase, atleast 1 lowercase, atleast 1 number & atleast 1 special character.");
			throw new PasswordNotValidException("Password should have at least 8 characters, atleast 1 uppercase, atleast 1 lowercase, atleast 1 number & atleast 1 special character.");
		}
		System.out.println("Admin added successfully with Admin Id : "+admin.getId());
			adminRepository.save(admin);
		return new ResponseEntity<>("Admin added successfully",HttpStatus.CREATED);
		
	}
	
	/**
	 * This method is to delete the Admin details from database & it returns string message
	 * @param Admin Id
	 * @throws AdminNotLoggedInException
	 * @throws AdminNotFoundException
	 * @return String message
	 */
	@Override
	public ResponseEntity<String> deleteAdmin(long id) throws AdminNotFoundException, AdminNotLoggedInException{
		if(adminRepository.existsById(id))
		{
			if(currentAdmin!=null)
			{
				adminRepository.deleteById(id);
				currentAdmin=null;
				System.out.println("Admin deleted successfully");
				return new ResponseEntity<>("Admin deleted successfully",HttpStatus.OK);
			}
			else {
				System.out.println("Admin not logged in");
				throw new AdminNotLoggedInException("Admin not logged in");
			}
		}
		System.out.println("Admin not found with Id : "+id);
		throw new AdminNotFoundException("Admin not found with Id : "+id);
	}
	
	/**
	 * This method is to update the Admin details from database & it returns updated Admin object
	 * @param Admin object
	 * @param Admin Id 
	 * @throws AdminNotFoundException
	 * @throws AdminNotLoggedInException
	 * @return String message
	 */
	@Override
	public ResponseEntity<String> updateAdmin(Admin admin ,long id) throws AdminNotFoundException, AdminNotLoggedInException{
		
		if(adminRepository.existsById(id))
		{	
			if(currentAdmin!=null)
			{
				Admin existingAdmin = adminRepository.findById(id);
				existingAdmin.setEmailId(admin.getEmailId());
				String encryptedPassword = Hashing.sha256().hashString(admin.getPassword(),StandardCharsets.UTF_8).toString();
				existingAdmin.setPassword(encryptedPassword);
				existingAdmin.setFirstName(admin.getFirstName());
				existingAdmin.setLastName(admin.getLastName());
				existingAdmin.setPhoneNumber(admin.getPhoneNumber());
				adminRepository.save(existingAdmin);
				System.out.println("Admin details updated successfully");
				return new ResponseEntity<>("Admin details updated successfully",HttpStatus.OK);
			}
			else {
				System.out.println("Admin not logged in");
				throw new AdminNotLoggedInException("Admin not logged in");
			}
		}
		System.out.println("Admin not found with Id : "+id);
		throw new AdminNotFoundException("Admin not found with Id : "+id);

	}
	
	/**
	 * This method is to login the Admin in the system
	 * It throws UserNotFoundException & InvalidLoginCredentialsException
	 * @param Admin Id
	 * @param Admin password
	 * @throws AdminNotFoundException
	 * @throws InvalidLoginCredentialsException
	 * @return Http Response
	 */
	@Override
	public ResponseEntity<Object> loginAdmin(AdminLogin adminLogin)throws AdminNotFoundException, InvalidLoginCredentialsException {
		String encryptedPassword = Hashing.sha256().hashString(adminLogin.getAdminPassword(),StandardCharsets.UTF_8).toString();
		if(adminRepository.findById(adminLogin.getAdminId())==null) {
			System.out.println("Admin not found with id: "+adminLogin.getAdminId());
			throw new AdminNotFoundException("Admin not found with id: "+adminLogin.getAdminId());
		}
		else if(adminRepository.findByIdAndPassword(adminLogin.getAdminId(),encryptedPassword).isEmpty()) {
			System.out.println("Invalid login credentials");
			throw new InvalidLoginCredentialsException("Invalid login credentials");
		}
		else if(currentAdmin==null) {
			currentAdmin=adminRepository.findByIdAndPassword(adminLogin.getAdminId(),encryptedPassword).get(0);
			System.out.println("Admin with id "+currentAdmin.getId()+" logged in successfully");
			return new ResponseEntity<>("Login successful",HttpStatus.OK);
			}
		System.out.println("Login failed, admin with id "+adminLogin.getAdminId()+" already logged in.");
		return new ResponseEntity<>("Login failed, admin already logged in.",HttpStatus.BAD_REQUEST);
	}
	
	/**
	 * This method is to logout the admin from the system
	 * @throws UserNotLoggedInException
	 * @return Http Response
	 */
	@Override
	public ResponseEntity<Object> logoutAdmin() throws AdminNotLoggedInException
	{
		if(currentAdmin!=null) {
			currentAdmin=null;
			System.out.println("Admin logged out successfully");
			return new ResponseEntity<>("Admin logged out successfully",HttpStatus.OK);
		}
		System.out.println("No admin logged in");
		throw new AdminNotLoggedInException("No admin logged in");
	}

	/**
	 * This method is to view the User from the system
	 * @param User Id
	 * @return User object
	 * @throws UserNotFoundException 
	 */
	@Override
	public User viewUser(long userId) throws UserNotFoundException {
		if(userRepository.existsById(userId))
		{
			System.out.println("User found with "+userId);
			return userRepository.findById(userId).get();
			
		}
		System.out.println("No user exists with id "+userId);
		throw new UserNotFoundException("No user found with id "+userId);
	}

	
	@Override
	public List<User> allUsers()throws UserNotFoundException{
		return userRepository.findAll();
	}
	
	

}