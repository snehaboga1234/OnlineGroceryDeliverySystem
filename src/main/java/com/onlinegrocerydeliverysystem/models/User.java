package com.onlinegrocerydeliverysystem.models;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * This is the User Model & an Entity Class which extends Person.java Class
 * @see User
 * @version 1.0
 */
@Entity
@Table(name="users")
public class User extends Person {

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="user_id", referencedColumnName="id")
	List<Address> address;
	public User() {

	}	
	
	/**
	 * Parameterized Constructor
	 * @param emailId
	 * @param password
	 * @param firstName
	 * @param lastName
	 * @param phoneNumber
	 */
	public User(String emailId, String password, String firstName, String lastName, Long phoneNumber) {
		super();
	}
	
	

	/**
	 * @return the address
	 */
	public List<Address> getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(List<Address> address) {
		this.address = address;
	}


}