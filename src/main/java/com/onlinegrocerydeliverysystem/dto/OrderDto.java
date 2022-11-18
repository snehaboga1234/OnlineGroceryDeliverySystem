package com.onlinegrocerydeliverysystem.dto;

import java.sql.Date;
import java.util.List;

import com.onlinegrocerydeliverysystem.models.Order;
import com.onlinegrocerydeliverysystem.models.OrderItem;

public class OrderDto {

	/**
	 * User Id associated with the order.
	 */
	private long userId;

	/**
	 * Creation Date associated with the order.
	 */
	private Date creationDate;

	/**
	 * Total price of the order.
	 */
	private double totalPrice;

	/**
	 * Items associated with the order.
	 */
	private List<OrderItem> orderItems;

	/**
	 * User associated with the order.
	 */
	private UserDto user;

	/**
	 * Default constructor of order class.
	 */
	public OrderDto() {
		super();
	}
	

	/**
	 * @param userId
	 * @param creationDate
	 * @param totalPrice
	 * @param orderItems
	 * @param user
	 */
	public OrderDto(Order order) {
		this.userId = order.getUserId();
		this.creationDate = order.getCreationDate();
		this.totalPrice = order.getTotalPrice();
		this.orderItems = order.getOrderItems();
		this.user = new UserDto(order.getUser());
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
	 * @return the creationDate
	 */
	public Date getCreationDate() {
		return creationDate;
	}

	/**
	 * @param creationDate the creationDate to set
	 */
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	/**
	 * @return the totalPrice
	 */
	public double getTotalPrice() {
		return totalPrice;
	}

	/**
	 * @param totalPrice the totalPrice to set
	 */
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	/**
	 * @return the orderItems
	 */
	public List<OrderItem> getOrderItems() {
		return orderItems;
	}

	/**
	 * @param orderItems the orderItems to set
	 */
	public void setOrderItems(List<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}

	/**
	 * @return the user
	 */
	public UserDto getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(UserDto user) {
		this.user = user;
	}
	
}
