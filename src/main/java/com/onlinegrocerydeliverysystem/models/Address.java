package com.onlinegrocerydeliverysystem.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Address {
	
	@Id
	@GeneratedValue
	private long id;
	private String location;
	private String city;
	private String state;
	private String zipcode;
	private String country;
	@ManyToOne
	@JoinColumn(name = "user_id", referencedColumnName = "id", insertable = false, updatable = false)
	User user;
	
	/**
	 * @return the location
	 */
	public String getLocation() {
		return location;
	}
	/**
	 * @param location the location to set
	 */
	public void setLocation(String location) {
		this.location = location;
	}
	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}
	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}
	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}
	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}
	/**
	 * @return the zipcode
	 */
	public String getZipcode() {
		return zipcode;
	}
	/**
	 * @param zipcode the zipcode to set
	 */
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	/**
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}
	/**
	 * @param country the country to set
	 */
	public void setCountry(String country) {
		this.country = country;
	}
	/**
	 * @param void
	 * @return whole address
	 */
	@Override
	public String toString() {
		return "Address [location=" + location + ", city=" + city + ", state=" + state + ", zipcode=" + zipcode
				+ ", country=" + country + "]";
	}
	/**
	 * @param location
	 * @param city
	 * @param state
	 * @param zipcode
	 * @param country
	 */
	public Address(String location, String city, String state, String zipcode, String country) {
		this.location = location;
		this.city = city;
		this.state = state;
		this.zipcode = zipcode;
		this.country = country;
	}
	
	public Address()
	{
	}
}
