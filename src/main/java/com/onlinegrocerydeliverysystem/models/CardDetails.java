package com.onlinegrocerydeliverysystem.models;

import java.sql.Date;

import javax.validation.constraints.Pattern;

/**
 * Class to represent card details.
 * 
 * @see CardDetails
 * @version 1.0
 */
public class CardDetails {

	/**
	 * Card Number
	 */
	@Pattern(regexp = "^[0-9]{16}$", message = "The entered card number is not valid.")
	private String cardNumber;

	/**
	 * Card Holder's Name
	 */
	@Pattern(regexp = "^[A-Za-z]+$")
	private String cardHolderName;

	/**
	 * Card Expiry Date
	 */
	private Date expiryDate;

	/**
	 * CVV Number
	 */
	@Pattern(regexp = "^[0-9]{3}$", message = "The entered cvv is not valid.")
	private String cvv;

	/**
	 * Default Constructor
	 */
	public CardDetails() {
		super();
	}

	/**
	 * Parameterized Constructor.
	 * 
	 * @param cardNumber
	 * @param cardHolderName
	 * @param expiryDate
	 * @param cvv
	 */
	public CardDetails(String cardNumber, String cardHolderName, Date expiryDate, String cvv) {
		super();
		this.cardNumber = cardNumber;
		this.cardHolderName = cardHolderName;
		this.expiryDate = expiryDate;
		this.cvv = cvv;
	}

	/**
	 * 
	 * @return cardNumber
	 */
	public String getCardNumber() {
		return cardNumber;
	}

	/**
	 * 
	 * @param cardNumber
	 */
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	/**
	 * 
	 * @return cardHolderName
	 */
	public String getCardHolderName() {
		return cardHolderName;
	}

	/**
	 * 
	 * @param cardHolderName
	 */
	public void setCardHolderName(String cardHolderName) {
		this.cardHolderName = cardHolderName;
	}

	/**
	 * 
	 * @return expiryDate
	 */
	public Date getExpiryDate() {
		return expiryDate;
	}

	/**
	 * 
	 * @param expiryDate
	 */
	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}

	/**
	 * 
	 * @return cvv
	 */
	public String getCvv() {
		return cvv;
	}

	/**
	 * 
	 * @param cvv
	 */
	public void setCvv(String cvv) {
		this.cvv = cvv;
	}

}
