package com.onlinegrocerydeliverysystem.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.validation.constraints.*;

/**
 *  This is the Person model class 
 *  @see Person
 *  @version  1.0
 */
@Entity
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public class Person {

	
	/**
	 * Primary Key Person Id
	 */
	@Id
	@GeneratedValue
	@Column(name="id")
	private Long  id;
	
	/**
	 * Email Id of the person
	 */
	@NotNull
	@Pattern(regexp = "[a-z0-9]+@[a-z]+\\.[a-z]{2,3}",message ="Email Id should contain only lowercase characters with symbol '@' & '.' ")
	@Column(name="emailid")
	private String emailId;
	
	/**
	 * Password of the person
	 */
	
	@NotNull
	@Column(name="password")
	private String password;
	
	/**
	 * First Name of the person
	 */
	@NotNull
	@Pattern(regexp = "^[A-Za-z]+$", message = "First name is invalid, must contain alphabets only.")
	@Column(name="fname")
	private String firstName;
	
	/**
	 * Last Name of the person
	 */
	@NotNull
	@Pattern(regexp = "^[A-Za-z]+$", message = "Last name is invalid, must contain alphabets only.")
	@Column(name="lname")
	private String lastName;
	
	/**
	 * Phone Number of the person
	 */
	@NotNull
	@Column(name="phone_no")
	@Digits(integer=10,fraction=0,message = "Phone Number should have only 10 digits")
	private Long phoneNumber;
	
	/**
	 * Default Constructor
	 */
	public Person() {
		
	}
	
	/**
	 * Parameterized Constructor
	 * @param emailId
	 * @param password
	 * @param firstName
	 * @param lastName
	 * @param phoneNumber
	 */
	public Person(String emailId, String password, String firstName, String lastName, Long phoneNumber) {
		
		this.emailId = emailId;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
	}
	
	/**
	 * Get Id
	 * @return id
	 */
	public Long getId() {
		return id;
	}
	
	/**
	 * Set Id
	 * @param id
	 */
	public void setId(Long id) {
		this.id=id;
	}
	/**
	 * Get Email Id
	 * @return emailId
	 */
	public String getEmailId() {
		return emailId;
	}
	/**
	 * Set Email Id
	 * @param emailId
	 */
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	/**
	 * Get Password
	 * @return password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * Set Password
	 * @param password
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * Get First Name
	 * @return firstName
	 */
	public String getFirstName() {
		return firstName;
	}
	/**
	 * Set First Name
	 * @param firstName
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	/**
	 * Get Last Name
	 * @return lastName
	 */
	public String getLastName() {
		return lastName;
	}
	/**
	 * Set Last Name
	 * @param lastName
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	/**
	 * Get Phone Number
	 * @return phoneNumber
	 */
	public Long getPhoneNumber() {
		return phoneNumber;
	}
	/**
	 * Set Phone Number
	 * @param phoneNumber
	 */
	public void setPhoneNumber(Long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	
}
