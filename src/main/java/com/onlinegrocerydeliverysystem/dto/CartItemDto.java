package com.onlinegrocerydeliverysystem.dto;

import java.util.Objects;

import com.onlinegrocerydeliverysystem.models.CartItem;

/**
 * DTO (Data Transfer Object) class for CartItem class. Used to hide the product
 * stock quantity from the JSON response sent to the client.
 * 
 * @see CartItemDto
 * @version 1.0
 *
 */

public class CartItemDto {

	/**
	 * Cart Item Id. This acts as the primary key for the CartItem entity.
	 */
	private long id;

	/**
	 * User Id with which the cart item is associated.
	 */
	private long userId;

	/**
	 * Product Id associated with the cart item.
	 */
	private long productId;

	/**
	 * Product associated with the cart item.
	 */
	private ProductDto product;

	/**
	 * Quantity of the product in the cart.
	 */
	private int quantity;

	/**
	 * Default constructor of the CartItemDto class.
	 */
	public CartItemDto() {
		super();
	}

	/**
	 * Parameterized constructor of the CartItemDto class. Used to initialize the
	 * attributes of the CartItemDto object with the required attributes of the
	 * CartItem object.
	 * 
	 * @param cartItem
	 */
	public CartItemDto(CartItem cartItem) {
		super();
		this.id = cartItem.getId();
		this.userId = cartItem.getUserId();
		this.productId = cartItem.getProductId();
		this.product = new ProductDto(cartItem.getProduct());
		this.quantity = cartItem.getQuantity();
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
	 * Getter method for product dto.
	 * 
	 * @return product dto associated with the cart item dto.
	 */
	public ProductDto getProduct() {
		return product;
	}

	/**
	 * Setter method for product dto.
	 * 
	 * @param product
	 */
	public void setProduct(ProductDto product) {
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
	* Hashcode method for CartItemDto class.
	*
	* @return hashcode of the object.
	*/
	@Override
	public int hashCode() {
	return Objects.hash(productId, quantity, userId);
	}



	/**
	* Equals method of the CartItemDto class.
	*
	* @param obj
	* @return true if the current object is equal to the parameter otherwise false.
	*/
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CartItemDto other = (CartItemDto) obj;
			return productId == other.productId && quantity == other.quantity && userId == other.userId;
	}
}
