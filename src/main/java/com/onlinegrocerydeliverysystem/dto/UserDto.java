package com.onlinegrocerydeliverysystem.dto;

import java.util.List;

import com.onlinegrocerydeliverysystem.models.Address;
import com.onlinegrocerydeliverysystem.models.User;

/**
 * DTO (Data Transfer Object) class for User class. Used to hide the password
 * from the JSON response to the client.
 *
 * @see UserDto
 * @version 1.0
 */
public class UserDto {

	private long userId;
	/**
	 * Email Id of the user.
	 */
	private String emailId;

	/**
	 * First Name of the user.
	 */
	private String firstName;

	/**
	 * Last Name of the user.
	 */
	private String lastName;

	/**
	 * Phone Number of the user.
	 */
	private long phoneNumber;

	/**
	 * Address of the user.
	 */
	private List<Address> address;
	/**
	 * Default constructor of the UserDto class.
	 */
	public UserDto() {
		super();
	}

	/**
	 * Parameterized constructor of the UserDto class which initializes the
	 * attributes of UserDto object with the required attributes of the User object.
	 * 
	 * @param user
	 */
	public UserDto(User user) {
		this.userId = user.getId();
		this.emailId = user.getEmailId();
		this.firstName = user.getFirstName();
		this.lastName = user.getLastName();
		this.phoneNumber = user.getPhoneNumber();
		this.address = user.getAddress();
	}

	/**
	 * Getter method for email id.
	 * 
	 * @return email id of the user.
	 */
	public String getEmailId() {
		return emailId;
	}

	/**
	 * Setter method for email id.
	 * 
	 * @param emailId
	 */
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	/**
	 * Getter method for first name.
	 * 
	 * @return first name of the user.
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Setter method for first name.
	 * 
	 * @param firstName
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * Getter method for last name.
	 * 
	 * @return last name of the user.
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * Setter method for last name.
	 * 
	 * @param lastName
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	

	/**
	 * @return the userId
	 */
	public long getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(long userId) {
		this.userId = userId;
	}

	/**
	 * Getter method for phone number.
	 * 
	 * @return phone number of the user.
	 */
	public long getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * Setter method for phone number.
	 * 
	 * @param phoneNumber
	 */
	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
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
