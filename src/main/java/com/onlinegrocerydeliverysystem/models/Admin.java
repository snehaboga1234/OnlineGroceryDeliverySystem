package com.onlinegrocerydeliverysystem.models;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * This is the Admin Model & an Entity Class which extends Person.java Class
 * @see Admin
 * @version 1.0
 */
@Entity
@Table(name="Admin")
public class Admin extends Person {
	
	/**
	 * Default Constructor	 */
	public Admin(){
		
	}
	
	/**
	 * Parameterized Constructor
	 * @param emailId
	 * @param password
	 * @param firstName
	 * @param lastName
	 * @param phoneNumber
	 */
	public Admin(String emailId, String password, String firstName, String lastName, Long phoneNumber) {
		super();
	}
	

}
