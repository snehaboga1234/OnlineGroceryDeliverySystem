package com.onlinegrocerydeliverysystem.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.onlinegrocerydeliverysystem.models.Bill;

/**
 * DTO (Data Transfer Object) class for Bill class.
 * 
 * @see BillDto
 * @version 1.0
 */
public class BillDto {

	/**
	 * Order Id associated with the bill.
	 */
	private long orderId;

	/**
	 * Order Items associated with the bill.
	 */
	private List<OrderItemDto> orderItems;

	/**
	 * Order Price associated with the bill.
	 */
	private double orderPrice;

	/**
	 * Status of the bill.
	 */
	private String status;

	/**
	 * Default constructor.
	 */
	public BillDto() {
		super();
	}

	/**
	 * Parameterized constructor.
	 * 
	 * @param bill
	 */
	public BillDto(Bill bill) {
		this.orderId = bill.getOrderId();
		this.orderItems = bill.getOrderItems().stream().map(OrderItemDto::new).collect(Collectors.toList());
		this.orderPrice = bill.getOrderPrice();
		this.status = bill.getStatus();
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
	public List<OrderItemDto> getOrderItems() {
		return orderItems;
	}

	/**
	 * 
	 * @param orderItems
	 */
	public void setOrderItems(List<OrderItemDto> orderItems) {
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
	 * @return status;
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
