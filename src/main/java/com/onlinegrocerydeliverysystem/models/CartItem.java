package com.onlinegrocerydeliverysystem.models;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;

/**
 * Entity class that represents a cart item.
 * 
 * @see CartItem
 * @version 1.0
 *
 */
@Entity
@Table(name = "cart_items")
public class CartItem {

	/**
	 * Primary key of the entity CartItem.
	 */
	@Id
	@GeneratedValue
	private long id;

	/**
	 * User Id with which the cart item is associated.
	 */
	@Column(name = "user_id")
	private long userId;

	/**
	 * Product Id associated with the cart item.
	 */
	@Column(name = "product_id")
	private long productId;

	/**
	 * Product associated with the cart item.
	 */
	@ManyToOne
	@JoinColumn(name = "product_id", referencedColumnName = "p_id", insertable = false, updatable = false)
	private Product product;

	/**
	 * Quantity of the product in the cart.
	 */
	@Min(value=1L,message = "Quantity should be positive or a non zero value")
	private int quantity;

	/**
	 * Default constructor of the CartItem class.
	 */
	public CartItem() {
		super();
	}

	/**
	 * Parameterized constructor of the CartItem class.
	 * 
	 * @param userId
	 * @param productId
	 * @param quantity
	 */
	public CartItem(long userId, long productId, int quantity) {
		super();
		this.userId = userId;
		this.productId = productId;
		this.quantity = quantity;
	}

	/**
	 * Getter method for id.
	 * 
	 * @return Id of the cart item.
	 */
	public long getId() {
		return id;
	}

	/**
	 * Setter method for id.
	 * 
	 * @param id
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * Getter method for user id.
	 * 
	 * @return user id associated with the cart item.
	 */
	public long getUserId() {
		return userId;
	}

	/**
	 * Setter method for the user id.
	 * 
	 * @param userId
	 */
	public void setUserId(long userId) {
		this.userId = userId;
	}

	/**
	 * Getter method for product id.
	 * 
	 * @return product id associated with the cart item.
	 */
	public long getProductId() {
		return productId;
	}

	/**
	 * Setter method for product id.
	 * 
	 * @param productId
	 */
	public void setProductId(long productId) {
		this.productId = productId;
	}

	/**
	 * Getter method for product.
	 * 
	 * @return product associated with the cart item.
	 */
	public Product getProduct() {
		return product;
	}

	/**
	 * Setter method for product.
	 * 
	 * @param product
	 */
	public void setProduct(Product product) {
		this.product = product;
	}

	/**
	 * Getter method for quantity
	 *
	 * @return quantity of the product associated with the cart item.
	 */
	public int getQuantity() {
		return quantity;
	}

	/**
	 * Setter method for quantity
	 * 
	 * @param quantity
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	/**
	 * toString method of CartItem class.
	 * 
	 * @return a string representation of the cart item object.
	 */
	@Override
	public String toString() {
		return "CartItem [userId=" + userId + ", productId=" + productId + ", quantity=" + quantity + "]";
	}

	/**
	 * hashCode method of CartItem class.
	 * 
	 * @return hashcode of the CartItem object.
	 */
	@Override
	public int hashCode() {
		return Objects.hash(productId, quantity, userId);
	}

	/**
	 * equals method of CartItem class.
	 * 
	 * @return true if this object is equal to the object passed as argument
	 *         otherwise false
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CartItem other = (CartItem) obj;
		return productId == other.productId && quantity == other.quantity && userId == other.userId;
	}

}
