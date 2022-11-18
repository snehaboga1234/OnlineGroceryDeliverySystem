package com.onlinegrocerydeliverysystem.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import com.onlinegrocerydeliverysystem.models.User;

/**
 * This is the User Repository Interface
 * User Repository Interface extends Jpa Repository
 */
public interface UserRepository extends JpaRepository<User, Long>{
	
	/**
	 * This method is used to find User by password & Id
	 * @param Email Id of the user
	 * @param Password of the user
	 * @return User  
	 */
	public List<User> findByEmailIdAndPassword(String emailId , String password);
	
	/**
	 * This method is used to find User by Email Id
	 * @param Email Id of the User
	 * @return User object
	 */
	public User findByEmailId(String emailId);
	
	/**
	 * This method is used to check if user exists in system or not
	 * @param String emailId of the User
	 * @return boolean
	 */
	public boolean existsByEmailId(String emailId);
}
