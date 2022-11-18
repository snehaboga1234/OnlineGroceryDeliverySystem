package com.onlinegrocerydeliverysystem.dto;

import com.onlinegrocerydeliverysystem.models.OrderItem;

/**
 * DTO (Data Transfer Object) class for OrderItem class.
 *
 * @see OrderItemDto
 * @version 1.0
 */
public class OrderItemDto {

	/**
	 * Product ID
	 */
	private long productId;

	/**
	 * Product Quantity.
	 */
	private int quantity;

	/**
	 * Price.
	 */
	private double price;

	/**
	 * Order Id associated with the order item.
	 */
	private long orderId;

	/**
	 * Product associated with the order item.
	 */
	private ProductDto product;

	/**
	 * Default constructor.
	 */
	public OrderItemDto() {
		super();
	}

	/**
	 * Parameterized constructor.
	 * 
	 * @param orderItem
	 */
	public OrderItemDto(OrderItem orderItem) {
		this.productId = orderItem.getProductId();
		this.quantity = orderItem.getQuantity();
		this.price = orderItem.getPrice();
		this.orderId = orderItem.getOrderId();
		this.product = new ProductDto(orderItem.getProduct());
	}

	/**
	 * 
	 * @return productId
	 */
	public long getProductId() {
		return productId;
	}

	/**
	 * 
	 * @param productId
	 */
	public void setProductId(long productId) {
		this.productId = productId;
	}

	/**
	 * 
	 * @return quantity
	 */
	public int getQuantity() {
		return quantity;
	}

	/**
	 * 
	 * @param quantity
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	/**
	 * 
	 * @return price
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * 
	 * @param price
	 */
	public void setPrice(double price) {
		this.price = price;
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
	 * @return product
	 */
	public ProductDto getProduct() {
		return product;
	}

	/**
	 * 
	 * @param product
	 */
	public void setProduct(ProductDto product) {
		this.product = product;
	}

}
