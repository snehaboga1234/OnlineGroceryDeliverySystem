package com.onlinegrocerydeliverysystem.models;

import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Entity class to represent an order.
 * 
 * @see Order
 * @version 1.0
 */
@Entity
@Table(name = "orders")
public class Order {

	/**
	 * Primary key of the order entity.
	 */
	@Id
	@GeneratedValue
	private long id;

	/**
	 * User Id associated with the order.
	 */
	@Column(name = "user_id")
	private long userId;

	/**
	 * Creation Date associated with the order.
	 */
	@Column(name = "creation_date")
	private Date creationDate;

	/**
	 * Total price of the order.
	 */
	@Column(name = "total_price")
	private double totalPrice;

	/**
	 * Items associated with the order.
	 */
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "order_id", referencedColumnName = "id")
	private List<OrderItem> orderItems;

	/**
	 * User associated with the order.
	 */
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id", referencedColumnName = "id", insertable = false, updatable = false)
	private User user;

	/**
	 * Default constructor of order class.
	 */
	public Order() {
		super();
	}

	/**
	 * @param userId
	 * @param creationDate
	 */
	public Order(long userId, Date creationDate) {
		this.userId = userId;
		this.creationDate = creationDate;
	}

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
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
	public User getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", userId=" + userId + ", creationDate=" + creationDate + ", totalPrice="
				+ totalPrice + ", orderItems=" + orderItems + ", user=" + user + "]";
	}
	
	
}
