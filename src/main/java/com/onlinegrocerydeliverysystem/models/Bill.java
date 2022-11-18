package com.onlinegrocerydeliverysystem.models;

import java.util.List;

/**
 * A class to represent an order's bill.
 * 
 * @see Bill
 * @version 1.0
 */
public class Bill {

	/**
	 * Order Id associated with the bill.
	 */
	private long orderId;

	/**
	 * Order Items associated with the bill.
	 */
	private List<OrderItem> orderItems;

	/**
	 * Order Price of the bill.
	 */
	private double orderPrice;

	/**
	 * Status of the bill.
	 */
	private String status;

	/**
	 * Default Constructor.
	 */
	public Bill() {
		super();
	}

	/**
	 * Parameterized constructor.
	 * 
	 * @param orderId
	 * @param orderItems
	 * @param orderPrice
	 * @param status
	 */
	public Bill(long orderId, List<OrderItem> orderItems, double orderPrice, String status) {
		super();
		this.orderId = orderId;
		this.orderItems = orderItems;
		this.orderPrice = orderPrice;
		this.status = status;
	}

	/**
	 * 
	 * @return orderId
	 */
	public long getOrderId() {
		return orderId;
	}

	/**
	 * 
	 * @param orderId
	 */
	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}

	/**
	 * 
	 * @return orderItems
	 */
	public List<OrderItem> getOrderItems() {
		return orderItems;
	}

	/**
	 * 
	 * @param orderItems
	 */
	public void setOrderItems(List<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}

	/**
	 * 
	 * @return orderPrice
	 */
	public double getOrderPrice() {
		return orderPrice;
	}

	/**
	 * 
	 * @param orderPrice
	 */
	public void setOrderPrice(double orderPrice) {
		this.orderPrice = orderPrice;
	}

	/**
	 * 
	 * @return status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * 
	 * @param status
	 */
	public void setStatus(String status) {
		this.status = status;
	}

}
