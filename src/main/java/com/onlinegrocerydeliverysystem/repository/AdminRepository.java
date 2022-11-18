package com.onlinegrocerydeliverysystem.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import com.onlinegrocerydeliverysystem.models.Admin;

/**
 * This is the Admin Repository Interface
 * Admin Repository Interface extends Jpa Repository
 */
public interface AdminRepository extends JpaRepository<Admin, Long>{
	
	/**
	 * This method is used to find Admin by password & Id
	 * @param String emailId of the Admin
	 * @param String password of the Admin
	 * @return Admin having specific emailId and password 
	 */
	public List<Admin> findByIdAndPassword(long id, String password);
	
	
	/**
	 * This method is to find Admin by using Id
	 * @param Admin Id
	 * @return Admin object 
	 */
	public Admin findById(long id);
	
	/**
	 * This method checks if Admin exists in system or not
	 * @param Admin Id
	 * @return boolean
	 */
	public boolean existsByEmailId(String emailId);
}